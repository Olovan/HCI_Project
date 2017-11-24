javac -cp "src" -d "bin" src\Main.java
pushd bin
jar -cfe EulersAbacus.jar Main *.class
move EulersAbacus.jar ..\EulersAbacus.jar
popd
