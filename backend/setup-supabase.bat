@echo off
echo ========================================
echo Hot Wheels - Supabase Configuration
echo ========================================
echo.

set /p SUPABASE_PASSWORD="Enter your Supabase database password: "

if "%SUPABASE_PASSWORD%"=="" (
    echo ERROR: Password cannot be empty!
    pause
    exit /b 1
)

echo.
echo Updating application.properties...

powershell -Command "(Get-Content 'src\main\resources\application.properties') -replace 'YOUR_SUPABASE_PASSWORD_HERE', '%SUPABASE_PASSWORD%' | Set-Content 'src\main\resources\application.properties'"

echo.
echo ========================================
echo Configuration Complete!
echo ========================================
echo.
echo Building project with Java 17...
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "PATH=%JAVA_HOME%\bin;%PATH%"

mvn clean package -DskipTests

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo BUILD SUCCESS!
    echo ========================================
    echo.
    echo Starting Spring Boot application...
    mvn spring-boot:run
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
)

pause
