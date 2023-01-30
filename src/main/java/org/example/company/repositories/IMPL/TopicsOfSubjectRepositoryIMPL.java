package org.example.company.repositories.IMPL;

import org.example.company.DTO.Topic;
import org.example.company.repositories.TopicsOfSubjectRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TopicsOfSubjectRepositoryIMPL implements TopicsOfSubjectRepository {

    @Override
    public List<Topic> getTopicsBySubjectId(UUID subjectId) {
        return getAllTopics()
                .stream()
                .filter(e -> e.getSubjectId().equals(subjectId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Topic> getAllTopics() {
        List<Topic> topicsList = new ArrayList<>();
        try {
            File file = new File("resources/Topics.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] topicFields = line.split(",");
                Topic topic = new Topic(UUID.fromString(topicFields[0]), topicFields[1], UUID.fromString(topicFields[2]));
                topicsList.add(topic);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return topicsList;
    }

    @Override
    public void addTopic(Topic topic) {
        try {
            FileWriter writer = new FileWriter("resources/Topics.txt",true);
            writer.write(topic.getId() + "," + topic.getName() + "," + topic.getSubjectId() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
