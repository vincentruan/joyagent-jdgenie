#!/usr/bin/env pwsh

# 开始启动后端程序
$BASEDIR = "./target/genie-backend"
$CLASSPATH = "$BASEDIR/conf;$BASEDIR/lib/*"
$MAIN_MODULE = "com.jd.genie.GenieApplication"
$LOGFILE = "./genie-backend_startup.log"

Write-Host "starting genie-backend :)" -ForegroundColor Green

# 启动 Java 应用
try {
    Start-Process -FilePath "java" -ArgumentList @(
        "-classpath", $CLASSPATH,
        "-Dbasedir=$BASEDIR",
        "-Dfile.encoding=UTF-8",
        $MAIN_MODULE
    ) -RedirectStandardOutput $LOGFILE -RedirectStandardError "$LOGFILE.err" -NoNewWindow -PassThru
    
    Write-Host "✅ Genie backend started successfully!" -ForegroundColor Green
    Write-Host "Log file: $LOGFILE" -ForegroundColor Cyan
    Write-Host "Error log: $LOGFILE.err" -ForegroundColor Cyan
} catch {
    Write-Host "❌ Failed to start genie-backend: $($_.Exception.Message)" -ForegroundColor Red
    exit 1
}
