javac -cp "src" -d "bin" src\Main.java
pushd bin
jar -cfm EulersAbacus.jar manifest.txt *.class
move EulersAbacus.jar ..\EulersAbacus.jar
popd
