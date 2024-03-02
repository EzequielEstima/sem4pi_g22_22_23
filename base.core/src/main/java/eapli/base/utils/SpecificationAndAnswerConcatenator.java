package eapli.base.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SpecificationAndAnswerConcatenator {

    private static final String SPLIT_REGEX = "#Answer:";

    public static String concatenate(String specification, Map<Integer, List<String>> answers){
        List<String> splitSpecification = Arrays.asList(specification.split(SPLIT_REGEX));
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(splitSpecification.get(0));

        for (int i = 1; i < splitSpecification.size() ; i++) {
            stringBuilder.append(SPLIT_REGEX);
            List<String> ans = answers.get(i);
            for (int j = 0; j < ans.size() ; j++){
                stringBuilder.append(ans.get(j));
                if (j != ans.size()-1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append(splitSpecification.get(i));
        }

        return stringBuilder.toString();
    }
}
