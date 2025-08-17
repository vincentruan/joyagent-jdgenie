#!/usr/bin/env pwsh

# Check if Node.js version is 18
$nodeVersion = node -v
$nodeMajorMinor = ($nodeVersion -replace 'v', '').Split('.')[0,1] -join '.'
if ([version]$nodeMajorMinor -lt [version]"18.0") {
    Write-Host "Node.js version 18 is required. Current version: $nodeVersion" -ForegroundColor Red
    exit 1
}

# Check if pnpm is installed
try {
    $pnpmVersion = pnpm -v
    Write-Host "pnpm version: $pnpmVersion" -ForegroundColor Green
} catch {
    Write-Host "pnpm is not installed. Installing pnpm@7.33.1 now..." -ForegroundColor Yellow
    Write-Host "RUN 'npm install -g pnpm@7.33.1' Installing pnpm..." -ForegroundColor Yellow
    npm install pnpm@7.33.1 -g
}

# Check if pnpm version is 7
try {
    $pnpmVersion = pnpm -v
    $pnpmMajorMinor = $pnpmVersion.Split('.')[0,1] -join '.'
    if ([version]$pnpmMajorMinor -lt [version]"7.0") {
        Write-Host "pnpm version 7 is required. Current version: $pnpmVersion" -ForegroundColor Red
        exit 1
    }
} catch {
    Write-Host "Failed to get pnpm version" -ForegroundColor Red
    exit 1
}

# Install dependencies
Write-Host "Installing dependencies..." -ForegroundColor Green
pnpm i --registry=https://registry.npmmirror.com

# Start development server
Write-Host "Starting development server..." -ForegroundColor Green
pnpm run dev

Write-Host "✅ Front end code start success!" -ForegroundColor Green
