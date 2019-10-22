'''
Question from Interview Cake: 

I like parentheticals (a lot).
"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."
Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.
Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
'''

import unittest


def get_closing_paren(sentence, opening_paren_index):

    # Find the position of the matching closing parenthesis
    stack = []
    openParanthesis = '('
    closeParanthesis = ')'
    passedOpen = False
    index_on_stack = None
    if (len(sentence) % 2 != 0):
        raise "Paranthesis Missing!"
    for index, char in enumerate(sentence):
        passedOpen = True if (index == opening_paren_index) else False
        if (char == openParanthesis):
            stack.append(char)
            index_on_stack = len(stack) - 1 if passedOpen else index_on_stack
        elif (char == closeParanthesis):
            if (stack[-1] == openParanthesis):
                if (len(stack) - 1 == index_on_stack):
                    return index
                else:
                    stack.pop()
            else:
                stack.append(char)
    return -1



# Tests

class Test(unittest.TestCase):

    def test_all_openers_then_closers(self):
        actual = get_closing_paren('((((()))))', 2)
        expected = 7
        self.assertEqual(actual, expected)


    def test_mixed_openers_and_closers(self):
        actual = get_closing_paren('()()((()()))', 5)
        expected = 10
        self.assertEqual(actual, expected)

    def test_no_matching_closer(self):
        with self.assertRaises(Exception):
            get_closing_paren('()(()', 2)


unittest.main(verbosity=2)
