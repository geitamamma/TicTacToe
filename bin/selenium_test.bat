@echo off
rem ***********************************************************************
rem This bat file runs Selenium tests (uses failsafe plugin).
rem ***********************************************************************

SET STAGING_SERVER="http://localhost:4567"
call mvn test-compile failsafe:integration-test
