'''
Probem Reference: https://www.interviewcake.com/question/python3/mesh-message
You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.
Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are encrypted while they're in transit.)

Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.

Given information about active users on the network, find the shortest route for a message from one user (the sender) to another (the recipient). Return a list of users that make up this route.

There might be a few shortest delivery routes, all with the same length. For now, let's just return any shortest route.

Your network information takes the form of a dictionary mapping username strings to a list of other users nearby:

  network = {
    'Min'     : ['William', 'Jayden', 'Omar'],
    'William' : ['Min', 'Noam'],
    'Jayden'  : ['Min', 'Amelia', 'Ren', 'Noam'],
    'Ren'     : ['Jayden', 'Omar'],
    'Amelia'  : ['Jayden', 'Adam', 'Miguel'],
    'Adam'    : ['Amelia', 'Miguel', 'Sofia', 'Lucas'],
    'Miguel'  : ['Amelia', 'Adam', 'Liam', 'Nathan'],
    'Noam'    : ['Nathan', 'Jayden', 'William'],
    'Omar'    : ['Ren', 'Min', 'Scott'],
    ...
}

For the network above, a message from Jayden to Adam should have this route:

  ['Jayden', 'Amelia', 'Adam']

'''

import unittest
from collections import deque


def get_path(graph, start_node, end_node):

    # Find the shortest route in the network between the two users
    if (start_node == end_node):
        return [start_node]

    nodes_path_dict = get_shortest_path(graph, start_node, end_node)
    if not nodes_path_dict:
        return nodes_path_dict

    transit_nodes = []
    current_node = end_node

    while current_node:
        transit_nodes.append(current_node)
        current_node = nodes_path_dict[current_node]

    transit_nodes.reverse()
    return transit_nodes


def get_shortest_path(graph, start_node, end_node):
    '''
        Breadth First Search - Find the shortest path between two nodes of a mesh graph
    '''

    if start_node not in graph:
        raise Exception("Start Node is missing in graph")

    if end_node not in graph:
        raise Exception("End node is missing in graph")

    nodes_to_visit = deque()
    nodes_to_visit.append(start_node)

    how_we_reached_nodes = {start_node: None}

    while len(nodes_to_visit) > 0:
        current_node = nodes_to_visit.popleft()

        if current_node == end_node:
            return how_we_reached_nodes

        for neighbor in graph.get(current_node, []):
            if neighbor not in how_we_reached_nodes:
                nodes_to_visit.append(neighbor)
                how_we_reached_nodes[neighbor] = current_node

    return None

# Tests


class Test(unittest.TestCase):

    def setUp(self):
        self.graph = {
            'a': ['b', 'c', 'd'],
            'b': ['a', 'd'],
            'c': ['a', 'e'],
            'd': ['a', 'b'],
            'e': ['c'],
            'f': ['g'],
            'g': ['f'],
        }

    def test_two_hop_path_1(self):
        actual = get_path(self.graph, 'a', 'e')
        expected = ['a', 'c', 'e']
        self.assertEqual(actual, expected)

    def test_two_hop_path_2(self):
        actual = get_path(self.graph, 'd', 'c')
        expected = ['d', 'a', 'c']
        self.assertEqual(actual, expected)

    def test_one_hop_path_1(self):
        actual = get_path(self.graph, 'a', 'c')
        expected = ['a', 'c']
        self.assertEqual(actual, expected)

    def test_one_hop_path_2(self):
        actual = get_path(self.graph, 'f', 'g')
        expected = ['f', 'g']
        self.assertEqual(actual, expected)

    def test_one_hop_path_3(self):
        actual = get_path(self.graph, 'g', 'f')
        expected = ['g', 'f']
        self.assertEqual(actual, expected)

    def test_zero_hop_path(self):
        actual = get_path(self.graph, 'a', 'a')
        expected = ['a']
        self.assertEqual(actual, expected)

    def test_no_path(self):
        actual = get_path(self.graph, 'a', 'f')
        expected = None
        self.assertEqual(actual, expected)

    def test_start_node_not_present(self):
        with self.assertRaises(Exception):
            get_path(self.graph, 'h', 'a')

    def test_end_node_not_present(self):
        with self.assertRaises(Exception):
            get_path(self.graph, 'a', 'h')


unittest.main(verbosity=2)
