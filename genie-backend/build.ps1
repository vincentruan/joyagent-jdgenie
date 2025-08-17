#!/usr/bin/env pwsh

# 需安装 jdk17
# $env:JAVA_HOME = "<your jdk path>"

# 需安装 maven3
Write-Host "Creating Maven settings file with Aliyun mirror..." -ForegroundColor Green

$mavenSettings = @"
<settings>
    <mirrors>
        <mirror>
            <id>aliyun</id>
            <url>https://maven.aliyun.com/repository/public</url>
            <mirrorOf>*</mirrorOf> <!-- 匹配所有仓库 -->
        </mirror>
    </mirrors>
</settings>
"@

$mavenSettings | Out-File -FilePath "aliyun-settings.xml" -Encoding UTF8

Write-Host "Building project with Maven..." -ForegroundColor Green
mvn clean package -DskipTests -s aliyun-settings.xml

if ($LASTEXITCODE -eq 0) {
    Write-Host "✅ Build completed successfully!" -ForegroundColor Green
} else {
    Write-Host "❌ Build failed with exit code: $LASTEXITCODE" -ForegroundColor Red
    exit $LASTEXITCODE
}
