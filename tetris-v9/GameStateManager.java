public class GameStateManager {


public static String CurrentState = "Game";
private static int Time = 0;
private static Boolean CanCount = false;

public static void SwitchPause(){

    if(CanCount){
    if(Time >200){
if(CurrentState == "Game"){
    CanCount = false;
    CurrentState = "Pause";
    Time = 0;
    Blocks.CanMove = false;
}else{
    CanCount = false;
    Time = 0;
    CurrentState = "Game";
    Blocks.CanMove = true;
}
}
    }
}

public static void Delta(int DeltaTime){

    if(CanCount){
    Time+=DeltaTime;
    }
}


public static void StartPause(){

    CanCount = true;
}






}