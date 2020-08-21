package com.zentechnology.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var list_recycler_view : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_recycler_view = findViewById(R.id.list_recycler_view)

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = ListAdapter(listMovies)
        }
    }

    private val listMovies = listOf(
        Movie("Harry Potter y la piedra filosoal", "Un niño huérfano se matricula en una escuela de hechicería, donde aprende la verdad sobre sí mismo, su familia y el terrible mal que acecha al mundo mágico."),
        Movie("El Señor de los Anillos", "En la Tierra Media, desde las verdes praderas de la Comarca, Frodo Bolsón, sobrino de Bilbo Bolsón, se embarca en una larga y peligrosa aventura para evitar que un anillo mágico que perteneció a su tío caiga ahora en poder del malvado "),
        Movie("El Hobbit", "Una adaptación animada de la historia de J.R.R. Tolkien acerca de las aventuras de un hobbit en busca de recuperar el oro del rey de los enanos."),
        Movie("Iron man - El hombre de hierro", "Después de haber estado cautivo en una cueva afgana, el multimillonario ingeniero Tony Stark crea una armadura única para luchar contra el mal."),
        Movie("Avengers: Infinity War", "Los Vengadores y sus aliados deben estar dispuestos a sacrificarlo todo para intentar derrotar al poderoso Thanos antes de que su ataque de devastación y ruina ponga fin al universo."),
        Movie("Guasón", "Arthur Fleck (Phoenix) es un hombre ignorado por la sociedad, cuya motivación en la vida es hacer reír. Pero una serie de trágicos acontecimientos le llevarán a ver el mundo de otra forma. Película basada en el popular personaje de DC Comics Joker, conocido como archivillano de Batman, pero que en este film tomará un cariz más realista y oscuro."),
        Movie("Capitán América: Civil War", "La implicación política en los asuntos de los Vengadores causa una ruptura entre el Capitán América e Iron Man."),
        Movie("Kick-Ass: Un superhéroe sin superpoderes", "Dave Lizewski es un inadvertido estudiante de secundaria y fanático de los cómics que un día decide convertirse en un superhéroe, aunque no tenga poderes, entrenamiento o una razón significativa para hacerlo.")
    )
}
