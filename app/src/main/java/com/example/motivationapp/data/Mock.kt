package com.example.motivationapp.data

import com.example.motivationapp.infrastructure.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int)

class Mock {

    private val inclusiveAll = MotivationConstants.FILTER.INCLUSIVE_ALL
    private val emoji = MotivationConstants.FILTER.EMOJI
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val listPhrase = listOf<Phrase>(
        Phrase("Superar é a arte de transformar grandes desafios em degraus para alcançar o topo da montanha do sucesso.", emoji),
        Phrase("Não sabendo que era impossível, foi lá e fez.", emoji),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", emoji),
        Phrase("Quando está mais escuro, vemos mais estrelas!", emoji),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", emoji),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", emoji),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", emoji),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase("Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )

    fun getPhrase(cat: Int): String {
        val listFilter = listPhrase.filter {it.category == cat || cat == inclusiveAll}
        val phrasePosition = Random.nextInt(listFilter.size)
        return listFilter[phrasePosition].description
    }
}