package com.github.jcarlosj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val superHeroes = listOf(
        SuperHero( "Spiderman", "Peter Parker", "Marvel", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg" ),
        SuperHero( "Darevil", "Matthew Michael Murdock", "Marvel", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg" ),
        SuperHero( "Wolverine", "James Howlett", "Marvel", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg" ),
        SuperHero( "Batman", "Bruce Wayne", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg" ),
        SuperHero( "Thor", "Thor Odinson", "Marvel", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg" ),
        SuperHero( "Flash", "Jay Garrick", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png" ),
        SuperHero( "Green Lantern", "Alan Scott", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg" ),
        SuperHero( "Wonder Woman", "Princess Diana", "DC", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg" )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}