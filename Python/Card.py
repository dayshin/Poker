class Card:
    suits = ["♣","♦","♥","♠"]
    ranks = ["2","3","4","5","6","7","8","9","T","J","Q","K","A"]
    def __init__(self,suit,rank):
        self.suit = suit
        self.rank = rank
    def info():
        return suits[self.suit] + ranks[self.rank];
    def display():
        print(info())
    def compare()
