import random
import Player
class Table:
    cards = ["2D","2C","2H","2S",
    "3D","3C","3H","3S",
    "4D","4C","4H","4S",
    "5D","5C","5H","5S",
    "6D","6C","6H","6S",
    "7D","7C","7H","7S",
    "8D","8C","8H","8S",
    "9D","9C","9H","9S",
    "10D","10C","10H","10S",
    "JD","JC","JH","JS",
    "QD","QC","QH","QS",
    "KD","KC","KH","KS",
    "1D", "1C", "1H", "1S"]
    players = []
    def __init__(self, numPlayers):
        self.numPlayers = numPlayers
        self.dealPlayers()
    def dealPlayers(self):
        cards = self.cards
        numPlayers = self.numPlayers
        players = self.players
        print()
        for num in range(1, numPlayers + 1 ):
            print("Player " + str(num))
            card1 = random.choice(cards)
            cards.remove(card1)
            card2 = random.choice(cards)
            cards.remove(card2)
            players.append(Player.Player(card1, card2))
            print(card1)
            print(card2)
            print()



    def dealBoard(self, progression):
        cards = self.cards
        if(progression == "flop"):
            card1 = random.choice(cards)
            cards.remove(card1)
            card2 = random.choice(cards)
            cards.remove(card2)
            card3 = random.choice(cards)
            cards.remove(card3)
            print(card1, card2, card3)
        elif(progression == "turn"):
            turn = random.choice(cards)
            cards.remove(turn)
            print(turn)
        else:
            river = random.choice(cards)
            cards.remove(river)
            print(river)
newTable = Table(5)
#newTable.dealPlayers()
#newTable.dealBoard("flop")
#newTable.dealBoard("turn")
#newTable.dealBoard("river")
