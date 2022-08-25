#  https://www.youtube.com/watch?v=xlVX7dXLS64&ab_channel=Reducible
#  https://leetcode.com/problems/flood-fill/

#  Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
#  Output: [[2,2,2],[2,2,0],[2,0,1]]


class Solution:
    def floodFill(self, image, sr, sc, newColor):
        queue = [(sr, sc)]
        while len(queue) > 0:
            current = queue.pop(0)
            currentindex = current[0]
            currentColour = image[current[0]][current[1]]
            row = current[0]
            col = current[1]
            if currentColour == newColor:
                continue
            else:
                image[current[0]][current[1]] = newColor

                if row - 1 >= 0 and image[row - 1][col] == currentColour:
                    # go up
                    queue.append((row - 1, col))

                if row + 1 < len(image) and image[row + 1][col] == currentColour:
                    # go down
                    queue.append((row + 1, col))

                if col - 1 >= 0 and image[row][col - 1] == currentColour:
                    # go left
                    queue.append((row, col - 1))

                if col + 1 < len(image[row]) and image[row][col + 1] == currentColour:
                    # go right
                    queue.append((row, col + 1))

        return image



