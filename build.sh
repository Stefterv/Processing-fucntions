#!/bin/bash
javac -cp /Applications/Processing.app/Contents/Java/core.jar -d . src/*.java
jar cvf library/func.jar func/func.class