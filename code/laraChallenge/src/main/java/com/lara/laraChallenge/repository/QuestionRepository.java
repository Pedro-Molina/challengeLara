package com.lara.laraChallenge.repository;

import com.lara.laraChallenge.entity.IntQuestion;
import com.lara.laraChallenge.entity.OptionButton;
import com.lara.laraChallenge.entity.QuestionFreeText;
import com.lara.laraChallenge.entity.QuestionMultipleChoice;
import lombok.Getter;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QuestionRepository {

    //Se alamacenan todas las preguntas
    private List<IntQuestion> questions;

    private static QuestionRepository questionRepositoryInstance = null;


    private QuestionRepository() {
        // Inicialización de la lista de preguntas
        questions = new ArrayList<>();
        questions.add(new QuestionFreeText(1L, "¿Cómo te sientes acerca de tu trabajo actual?"));
        questions.add(new QuestionFreeText(2L, "¿Qué aspecto de tu trabajo te gustaría mejorar?"));
        questions.add(new QuestionFreeText(3L, "¿Qué tipo de apoyo necesitas de parte del equipo o la empresa para tener un mejor desempeño?"));
        questions.add(new QuestionFreeText(4L, "¿Cuál es tu mayor logro en el trabajo hasta ahora?"));
        questions.add(new QuestionFreeText(5L, "¿Cuál es tu mayor desafío en el trabajo actualmente?"));
        questions.add(new QuestionFreeText(6L, "¿Hay algo que te impida realizar tu trabajo de manera efectiva?"));
        questions.add(new QuestionFreeText(7L, "¿Cómo describirías el ambiente de trabajo en esta empresa?"));
        questions.add(new QuestionFreeText(8L, "¿Qué te motiva a seguir trabajando aquí?"));
        questions.add(new QuestionFreeText(9L, "¿Hay algún tipo de capacitación o desarrollo profesional que te gustaría recibir?"));
        questions.add(new QuestionFreeText(10L, "¿Cómo crees que podríamos mejorar la comunicación dentro del equipo o la empresa?"));
        questions.add(new QuestionMultipleChoice(11L, "¿Cuál es tu área de interés principal?", Arrays.asList(
                new OptionButton("Desarrollo", "development"),
                new OptionButton("Diseño", "design"),
                new OptionButton("Gestión de Proyectos", "project_management"),
                new OptionButton("Recursos Humanos", "human_resources")
        )));

        questions.add(new QuestionMultipleChoice(12L, "¿Cuál es tu nivel de satisfacción con el ambiente de trabajo?", Arrays.asList(
                new OptionButton("Muy satisfecho", "very_satisfied"),
                new OptionButton("Satisfecho", "satisfied"),
                new OptionButton("Neutral", "neutral"),
                new OptionButton("Insatisfecho", "unsatisfied"),
                new OptionButton("Muy insatisfecho", "very_unsatisfied")
        )));

        questions.add(new QuestionMultipleChoice(13L, "¿Qué te gustaría mejorar en tu desarrollo profesional?", Arrays.asList(
                new OptionButton("Adquirir nuevas habilidades técnicas", "new_technical_skills"),
                new OptionButton("Desarrollar habilidades de liderazgo", "leadership_skills"),
                new OptionButton("Explorar oportunidades de crecimiento interno", "internal_growth"),
                new OptionButton("Obtener una certificación específica", "specific_certification"),
                new OptionButton("Otro", "other")
        )));

// Puedes seguir agregando más preguntas aquí

    }

    // Método estático para obtener la instancia única del Singleton
    public static QuestionRepository getInstance() {
        if (questionRepositoryInstance == null) {
            questionRepositoryInstance = new QuestionRepository();
        }
        return questionRepositoryInstance;
    }
    public List<IntQuestion>  selectConversationQuestions(List<Long> questionsId) throws Exception{
        List<IntQuestion> foundQuestions = new ArrayList<>();
        // Iterar sobre cada ID de pregunta
        for (Long id : questionsId) {
            // Buscar la pregunta con el ID especificado
            for (IntQuestion question : questions) {
                if (question.getQuestionId() == id) {
                    foundQuestions.add(question);
                    break;
                }
            }
        }
        if (foundQuestions.size() != questionsId.size()){
            throw new Exception();
        }
        return foundQuestions;
    }


    public IntQuestion getLastQuestion(){
        QuestionFreeText lastQuestion = new QuestionFreeText(1L,"Gracias por contestar todas las preguntas. ¡Hablamos pronto!\n");
        return lastQuestion;
    }

}
