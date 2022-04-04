# 4D-Cleanup
This program was written for an Algorithm Analysis class at California State University Long Beach. It closely resembles the travelling salesman problem with a slight twist. 


## The Problem
A race of super advanced aliens have been conducting research about our universe. They have deployed 50,000 probes in unique coordinates through space-time and are finally ready to retrieve them. The coordinates are 4 dimensional, as the aliens are so advanced. They would like to collect each probe in the shortest path possible that visits each probe once.


## My Solution
My program implements a nearest neighbor algorithm to approximate the cleanup path. This allows it to process a large number of points quickly and provide a good approximation of the best case.

The input of the program is a text file, points.txt, which uses the following format:
`
[(x1, y1, z1, t1), (x2, y2, z2, t2), ...]
`

The final list of coordinates in order of visitation is written to output.txt using the same format.
