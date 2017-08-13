package net.javaex;

/**
 * Created by Vardan on 8/13/2017.
 */
public class Rule {
    private String name;
    private String definitionType;
    private String definition;
    private String condition;
    private String conclusion;


    public enum Types {
        AND('&'),
        OR('|');
        private int value;
        private Types(char value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(String definitionType) {
        this.definitionType = definitionType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        String conditionString = "";
        if (this.condition != null) {
            conditionString = ", if " + condition + " => ";
        }

        return name + " Rule for " +
                definitionType + " " +
                definition + ": " +
                conditionString +
                conclusion +
                '}';
    }
}
