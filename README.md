# Maximize_currency_exchange
-Given custom input of available currency exchange rates with start currency and end currency required, the Algorithm maximizes the value of return we get while converting start currency to the required currency 
-Example: if we have currency A, B, C, and D with us and we want to convert A to B 
Assume , A -> B = 100 ( direct conversion gives us 100).
But if we convert A->C->D->B = 110 ( but indirect conversion gives us 110).
We notice the indirect conversion maximizes our profit and will be the value returned by the Algorithm
-I developed the Algorithm by creating a graph and used Dijkstra's Algorithm as a reference.
-Dijkstra's Algorithm is usually used for finding the shortest path or value in a weighted graph, but I modified the Algorithm to get the maximum conversion rate instead of the minimum.
