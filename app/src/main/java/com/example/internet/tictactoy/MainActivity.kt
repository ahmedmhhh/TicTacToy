package com.example.internet.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view:View){
        val buSelected = view as Button
        var cellID=0
        when(buSelected.id){
            R.id.bu1->cellID=1
            R.id.bu2->cellID=2
            R.id.bu3->cellID=3
            R.id.bu4->cellID=4
            R.id.bu5->cellID=5
            R.id.bu6->cellID=6
            R.id.bu7->cellID=7
            R.id.bu8->cellID=8
            R.id.bu9->cellID=9
        }

        PlayGame(cellID,buSelected)
    }

    var Player1=ArrayList<Int>()
    var Player2=ArrayList<Int>()
    var ActionPlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){

        if(ActionPlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellID)
            ActionPlayer=2
        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.RED)
            Player2.add(cellID)
            ActionPlayer=1
        }

        buSelected.isEnabled=false
        CheckWinner()

    }

    fun CheckWinner(){
        var winner=-1

        //row1
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3)){
            winner=1
        }
        if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3)){
            winner=2
        }

        //row2
        if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6)){
            winner=1
        }
        if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6)){
            winner=2
        }

        //row3
        if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9)){
            winner=2
        }


        //col1
        if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7)){
            winner=1
        }
        if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7)){
            winner=2
        }

        //col2
        if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8)){
            winner=1
        }
        if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8)){
            winner=2
        }

        //col3
        if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9)){
            winner=2
        }

        if(winner!=-1){
            if(winner==1)
                Toast.makeText(this,"Player 1 win the game",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Player 2 win the game",Toast.LENGTH_SHORT).show()
        }
    }
}
