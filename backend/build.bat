@echo off
echo ========================================
echo Building Hot Wheels Backend with Java 17
echo ========================================

REM Try to find Java 17
if exist "C:\Program Files\Java\jdk-17" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.1" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.1"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.2" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.2"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.3" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.3"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.4" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.4"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.5" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.5"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.6" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.6"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.7" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.7"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.8" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.8"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.9" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.9"
    echo Found Java 17 at: %JAVA_HOME%
) else if exist "C:\Program Files\Java\jdk-17.0.10" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17.0.10"
    echo Found Java 17 at: %JAVA_HOME%
) else (
    echo WARNING: Java 17 not found in standard location!
    echo Please set JAVA_HOME manually to your Java 17 installation
    echo Example: set JAVA_HOME=C:\Path\To\Java17
    pause
    exit /b 1
)

set "PATH=%JAVA_HOME%\bin;%PATH%"

echo.
echo Verifying Java version:
java -version

echo.
echo ========================================
echo Running: mvn clean install
echo ========================================
mvn clean install

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo BUILD SUCCESS!
    echo ========================================
) else (
    echo.
    echo ========================================
    echo BUILD FAILED!
    echo ========================================
)

pause
