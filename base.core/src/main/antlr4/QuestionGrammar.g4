grammar QuestionGrammar;
prog: matching_type_question
      | select_missing_words
      | true_false_question
      | multiple_choice_question
      | short_answer_question
      | numerical_question;


/////////////////////////
multiple_choice_question : HASH MC_Q points question list_with_title multiple_choice_answer multiple_choice_solution (feedback)?
                         ;
multiple_choice_answer : ANSWER_ENTRY list_phrases?
                       ;
multiple_choice_solution : SOLUTION_ENTRY list_phrases
                         ;
/////////////////////////
matching_type_question : HASH MT_Q points question list_with_title list_with_title matching_type_answer matching_type_solution (feedback)?
                       ;
matching_type_answer : ANSWER_ENTRY (phrase DASH phrase (COMMA phrase DASH phrase)*)?
                     ;
matching_type_solution : SOLUTION_ENTRY phrase DASH phrase (COMMA phrase DASH phrase)*
                       ;
//////////////////////////
true_false_question : HASH TF_Q points question true_false_answer true_false_solution (feedback)?
                    ;
true_false_answer: ANSWER_ENTRY TRUE_FALSE_RESPONSES?
                 ;
true_false_solution: SOLUTION_ENTRY TRUE_FALSE_RESPONSES
                   ;
////////////////////////////
select_missing_words : HASH SMW_Q points question missing_word_phrase list_with_title+ missing_word_answer missing_word_solution (feedback)?
                     ;
missing_word_phrase : NEWLINE+ phrase? (MISSING_WORD phrase)+ MISSING_WORD?
                    | NEWLINE+ MISSING_WORD? (phrase MISSING_WORD)+ phrase?
                    ;
missing_word_answer: ANSWER_ENTRY list_phrases?
                   ;
missing_word_solution: SOLUTION_ENTRY list_phrases
                     ;
list_phrases: phrase (COMMA phrase)*
            ;
//////////////////////
short_answer_question: HASH SA_Q points question short_answer_answer short_answer_solution (feedback)?
                     ;
short_answer_answer: ANSWER_ENTRY phrase?
                   ;
short_answer_solution: SOLUTION_ENTRY phrase
                     ;
////////////////////
numerical_question: HASH N_Q points question numerical_answer numerical_solution (feedback)?
                  ;
numerical_answer: ANSWER_ENTRY ((INT|NUMERICAL_VALUE) WORD)?
                ;
numerical_solution: SOLUTION_ENTRY (INT|NUMERICAL_VALUE) WORD
                ;
/////////////////////
question: NEWLINE+ QUESTION_ENTRY phrase
        ;
points: NEWLINE+ POINTS_ENTRY INT
      ;
feedback: NEWLINE+ FEEDBACK_ENTRY phrase
        ;
phrase : phrase_word+
       ;

phrase_word : (WORD|INT|PUNCTUATION|COMMA|HASH|COLON|DASH)
            ;

list_with_title: NEWLINE+ title_list list?
               ;
title_list: phrase COLON
        ;
list: (topic_list)+
 ;
topic_list : (NEWLINE)+ DASH phrase
             ;

/////////////////////////
ANSWER_ENTRY : NEWLINE+ HASH 'Answer:';
SOLUTION_ENTRY : NEWLINE+ HASH 'Solution:';
TRUE_FALSE_RESPONSES : ('T' |'F'|'t'| 'f');

FEEDBACK_ENTRY : HASH 'Feedback:';
QUESTION_ENTRY : HASH 'Question:';
POINTS_ENTRY : HASH 'Points:';
MC_Q : 'Multiple Choice';
N_Q : 'Numerical';
SA_Q : 'Short Answer';
SMW_Q : 'Select Missing Words';
TF_Q : 'True/False Question';
MT_Q : 'Matching Type';
POINTS : 'Points';

COMMA : ',';
WS : [ \t]+ -> skip;
HASH : '#';
NEWLINE : [\r\n]+;
WORD: [A-Za-z]+;
COLON : ':' ;
DASH : '-';
INT : [0-9]+;
NUMERICAL_VALUE : INT COMMA INT;
PUNCTUATION : ~[A-Za-z \t\r\n];
MISSING_WORD : '||WORD||';