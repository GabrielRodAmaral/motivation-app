package com.example.motivationapp.data

import com.example.motivationapp.infrastructure.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int, val language: String)

class Mock {

    private val inclusiveAll = MotivationConstants.FILTER.INCLUSIVE_ALL
    private val emoji = MotivationConstants.FILTER.EMOJI
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val pt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val en = MotivationConstants.LANGUAGE.ENGLISH

    private val listPhrase = listOf<Phrase>(
        Phrase("Superar é a arte de transformar grandes desafios em degraus para alcançar o topo da montanha do sucesso.", emoji, pt),
        Phrase("Não sabendo que era impossível, foi lá e fez.", emoji, pt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", emoji, pt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", emoji, pt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", emoji, pt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", emoji, pt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", emoji, pt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, pt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, pt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, pt),
        Phrase("Enquanto não estivermos comprometidos, haverá hesitação!", sunny, pt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, pt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, pt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny, pt),

        Phrase("Overcoming is the art of transforming great challenges into steps to reach the top of the mountain of success.", emoji, en),
        Phrase("Not knowing it was impossible, he went there and did it.", emoji, en),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!", emoji, en),
        Phrase("When it's darker, we see more stars!", emoji, en),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.", emoji, en),
        Phrase("Don't stop when you're tired, stop when you're done.", emoji, en),
        Phrase("What can you do now that has the biggest impact on your success?", emoji, en),
        Phrase("The best way to predict the future is to invent it.", sunny, en),
        Phrase("You lose every chance you don't take.", sunny, en),
        Phrase("Failure is the spice that flavors success.", sunny, en),
        Phrase(" As long as we are not committed, there will be hesitation!", sunny, en),
        Phrase("If you don't know where you want to go, any way will do.", sunny, en),
        Phrase("If you believe, it makes all the difference.", sunny, en),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!", sunny, en)
    )

    fun getPhrase(cat: Int, lang: String): String {
        val listFilter =
            listPhrase.filter { (it.category == cat || cat == inclusiveAll) && it.language == lang }
        val phrasePosition = Random.nextInt(listFilter.size)
        return listFilter[phrasePosition].description
    }
}