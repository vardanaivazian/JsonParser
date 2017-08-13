package net.javaex;

import java.util.List;

/**
 * Created by Vardan on 8/13/2017.
 */
public class Main {
    public static void main(String[] args) {

        RuleIO ruleIO = new RuleIO();
        ruleIO.toJson();

        check("AB", "segment");
    }

    public static void check(String def, String defType) {
        RuleIO ruleIO = new RuleIO();
        List<Rule> rules = ruleIO.toObject();

        for (Rule rule : rules) {
            checkDefinition(rule, def);
        }
    }

    static void checkDefinition(Rule rule, String inputDefinition) {

        if ("any".equals(rule.getDefinitionType()) || rule.getDefinition().equals(inputDefinition)) {
            Rule rule1 = applyRuleToInput(rule, inputDefinition);
            System.out.println(rule1.toString());
        }
    }

    static void replaceRuleSymbols (Rule rule, String oldDef, String newDef) {

        rule.setDefinition(rule.getDefinition().replace(oldDef, newDef));

        if (rule.getCondition() != null)
            rule.setCondition(rule.getCondition().replace(oldDef, newDef));

        rule.setConclusion(rule.getConclusion().replace(oldDef, newDef));
    }

    static Rule applyRuleToInput(Rule rule, String def) {
        String definition = rule.getDefinition();

        switch (rule.getDefinitionType()) {
            case "any":
                replaceRuleSymbols(rule, "x", def);
                break;
            case "point":
                break;
            case "segment":
                replaceRuleSymbols(rule, "AB", def);
                break;
            case "triangle":
                replaceRuleSymbols(rule, "ABC", def);
                break;
        }
        return rule;
    }
}
