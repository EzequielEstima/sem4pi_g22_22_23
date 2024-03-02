REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET BASE_CP=base.app.sharedboardServer\target\base.app.sharedboardServer-1.4.0-SNAPSHOT.jar;base.app.sharedboardServer\target\dependency\*;

REM call the java VM, e.g,
java -cp %BASE_CP% eapli.base.app.sharedboardServer.SharedBoardAppServer