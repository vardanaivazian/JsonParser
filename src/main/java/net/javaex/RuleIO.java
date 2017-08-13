package net.javaex;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vardan on 8/13/2017.
 */
public class RuleIO {

    private String defaultPath = "res/rules/rules.json";

    public void toJson() {
//        System.out.println("toJson");
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();

        List<Rule> rules = createDummyObject();

        try {
            writer.writeValue(new File("rules.json"), rules);
            // Convert object to JSON string and save into a file directly

            // Convert object to JSON string
//            String jsonInString = mapper.writeValueAsString(rules);

            // Convert object to JSON string and pretty print
            /*String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rules);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Rule> toObject() {
        System.out.println("toObject");
        ObjectMapper mapper = new ObjectMapper();

        List<Rule> rules = new LinkedList<>();

        try {

            // Convert JSON string from file to Object
//            Rule rule = mapper.readValue(new File("/res/rules/rules.json"), Rule.class);
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(defaultPath);
            rules = mapper.readValue(resourceAsStream, new TypeReference<List<Rule>>(){});

            /*for (Rule rule : rules) {
                String ruleString = mapper.writeValueAsString(rule);
//            String ruleString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rule);
                System.out.println("From File");
                System.out.println(ruleString);
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rules;
    }

    private List<Rule> createDummyObject() {

        List<Rule> rules = new LinkedList<>();
        Rule rule = new Rule();
        rule.setName("reflexive");
        rule.setDefinitionType("any");
        rule.setDefinition("x");
        rule.setConclusion("x = x");

        rules.add(rule);

        rule = new Rule();
        rule.setName("symmetric");
        rule.setDefinitionType("any");
        rule.setDefinition("x, y");
        rule.setCondition("x = y");
        rule.setConclusion("y = x");

        rules.add(rule);

        rule = new Rule();
        rule.setName("transitive");
        rule.setDefinitionType("any");
        rule.setDefinition("x, y, z");
        rule.setCondition("x = y & y = z");
        rule.setConclusion("x = z");

        rules.add(rule);

        rule = new Rule();
        rule.setName("segmentReflexivity123");
        rule.setDefinitionType("segment");
        rule.setDefinition("AB");
        rule.setConclusion("AB = BA");

        rules.add(rule);

        rule = new Rule();
        rule.setName("segmentReflexivity213");
        rule.setDefinitionType("segment");
        rule.setDefinition("ABC");
        rule.setConclusion("AB + BC = AC");

        rules.add(rule);

        return rules;

    }
}
