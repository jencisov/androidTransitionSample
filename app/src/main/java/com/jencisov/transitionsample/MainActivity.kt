package com.jencisov.transitionsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    private lateinit var rootContainer: ViewGroup
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var transitionMgr: Transition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootContainer = findViewById(R.id.rootContainer)
        transitionMgr = TransitionInflater.from(this).inflateTransition(R.transition.transition_two)
        scene1 = Scene.getSceneForLayout(rootContainer, R.layout.scene_one, this)
        scene2 = Scene.getSceneForLayout(rootContainer, R.layout.scene_two, this)

        scene1.enter()
    }

    fun goToScene2(view: View) = TransitionManager.go(scene2, transitionMgr)

    fun goToScene1(view: View) = TransitionManager.go(scene1, transitionMgr)

}