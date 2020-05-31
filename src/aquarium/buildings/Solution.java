package aquarium.buildings;

//Compiler version 1.8.0_111

import java.util.*;
import java.lang.*;

import static java.util.stream.Collectors.*;

class Solution {
    /**
     * @param {String[]} hand1
     * @param {String[]} hand2
     * @return {int} winner
     */

    public static int determine_winner(String[] hand1, String[] hand2) {
        int winner = 0;
        // Put your code here to calculate the winner
        List<Card> handList1 = new ArrayList<>();
        List<Card> handList2 = new ArrayList<>();
        for (int i = 0; i < hand1.length; i++) {

        }

        // Return the result, do not change the structure. winner = 1 -> Player 1 wins, winner = 2 -> Player 2 wins
        return winner;
    }


    ///// logic

    public enum Suit {
        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5),
        SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum HandRank {
        HIGH_CARD(0),
        PAIR(1),
        TWO_PAIR(2),
        THREE_OF_A_KIND(3),
        STRAIGHT(4),
        FLUSH(5),
        FULL_HOUSE(6),
        FOUR_OF_A_KIND(7),
        STRAIGHT_FLUSH(8);

        private final int value;

        HandRank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public class HandRankCounter {
        static final int FULL_HAND = 5;
        static final int FLUSH = FULL_HAND;
        static final int STRAIGHT = FULL_HAND;
        static final int FULL_HOUSE = FULL_HAND;
        static final int QUADS = 4;
        static final int SET = 3;
        static final int PAIR = 2;
        static final int HIGH_CARD = 1;
        private final HandRankCounter instance = new HandRankCounter();
        public List<EnumSet<Rank>> STRAIGHTS = setPossibleStraights();
        private List<Card> handCards = new ArrayList<>();
        private PokerHand pokerHand;

        private HandRankCounter() {
        }

        private List<EnumSet<Rank>> setPossibleStraights() {
            List<EnumSet<Rank>> straights = EnumSet.range(Rank.TWO, Rank.TEN).stream()
                    .map(rank -> EnumSet.range(rank, Rank.values()[rank.ordinal() + STRAIGHT - 1]))
                    .collect(toList());
            Collections.reverse(straights);
            straights.add(EnumSet.of(Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE));
            return Collections.unmodifiableList(straights);
        }

        public PokerHand getRank(List<Card> allCards) {
            if (allCards.size() != 7) throw new IllegalArgumentException("You have to pass 7 cards");

            if (isStraightFlush(allCards) ||
                    isFourOfAKind(allCards) ||
                    isFullHouse(allCards) ||
                    isFlush(allCards, true) ||
                    isStraight(allCards) ||
                    isSet(allCards) ||
                    isTwoPair(allCards) ||
                    isPair(allCards) ||
                    isHighCard(allCards)) {
            }
            return pokerHand;
        }


        private boolean isStraightFlush(List<Card> allCards) {
            if (isFlush(allCards, false) && isStraight(handCards)) {
                pokerHand = new PokerHand(HandRank.STRAIGHT_FLUSH, handCards);
                return true;
            }
            return false;
        }

        private boolean isFlush(List<Card> allCards, boolean finalResult) {
            Map<Suit, Long> suitsMap = getSuitMap(allCards);
            Suit popularSuit = getMostPopularSuit(suitsMap);

            if (suitsMap.get(popularSuit) >= FLUSH) {

                if (finalResult) {
                    handCards = allCards.stream()
                            .filter(c -> c.getSuit() == popularSuit)
                            .sorted()
                            .limit(FULL_HAND)
                            .collect(toList());

                    pokerHand = new PokerHand(HandRank.FLUSH, handCards);
                } else {
                    handCards = allCards.stream()
                            .filter(c -> c.getSuit() == popularSuit)
                            .collect(toList());
                }
                return true;
            }
            return false;
        }

        private boolean isStraight(List<Card> allCards) {
            EnumSet<Rank> ranks = allCards.stream()
                    .map(Card::getRank)
                    .collect(toCollection(() -> EnumSet.noneOf(Rank.class)));

            for (Set<Rank> straight : STRAIGHTS) {
                if (ranks.containsAll(straight)) {
                    handCards = allCards.stream()
                            .filter(c -> straight.contains(c.getRank()))
                            .collect(toList());

                    pokerHand = new PokerHand(HandRank.STRAIGHT, handCards);
                    return true;
                }
            }
            return false;
        }

        private boolean isFourOfAKind(List<Card> allCards) {
            handCards = getHighestCards(allCards, QUADS);

            if (handCards.size() == QUADS) {
                handCards.addAll(getMultipleHighestCards(allCards, FULL_HAND - QUADS));
                pokerHand = new PokerHand(HandRank.FOUR_OF_A_KIND, handCards);
                return true;
            }
            return false;
        }

        private boolean isFullHouse(List<Card> allCards) {
            handCards = getHighestCards(allCards, SET);
            handCards.addAll(getHighestCards(allCards, PAIR));

            if (handCards.size() == FULL_HOUSE) {
                pokerHand = new PokerHand(HandRank.FULL_HOUSE, handCards);
                return true;
            }
            return false;
        }

        private boolean isSet(List<Card> allCards) {
            handCards = getHighestCards(allCards, SET);

            if (handCards.size() == SET) {
                handCards.addAll(getMultipleHighestCards(allCards, FULL_HAND - SET));
                pokerHand = new PokerHand(HandRank.THREE_OF_A_KIND, handCards);
                return true;
            }
            return false;
        }

        private boolean isTwoPair(List<Card> allCards) {
            handCards = getHighestCards(allCards, PAIR);
            allCards.removeAll(handCards);
            handCards.addAll(getHighestCards(allCards, PAIR));

            if (handCards.size() == PAIR + PAIR) {
                handCards.addAll(getMultipleHighestCards(allCards, FULL_HAND - PAIR - PAIR));
                pokerHand = new PokerHand(HandRank.TWO_PAIR, handCards);
                return true;
            }
            return false;
        }

        private boolean isPair(List<Card> allCards) {
            handCards = getHighestCards(allCards, PAIR);

            if (handCards.size() == PAIR) {
                handCards.addAll(getMultipleHighestCards(allCards, FULL_HAND - PAIR));
                pokerHand = new PokerHand(HandRank.PAIR, handCards);
                return true;
            }
            return false;
        }

        private boolean isHighCard(List<Card> allCards) {
            handCards = getHighestCards(allCards, FULL_HAND);
            pokerHand = new PokerHand(HandRank.HIGH_CARD, handCards);
            return true;
        }

        private List<Card> getHighestCards(List<Card> allCards, int count) {
            EnumMap<Rank, Long> ranks = getRankMap(allCards);

            try {
                Rank cardsRank = ranks.entrySet().stream()
                        .filter(entry -> entry.getValue() == count)
                        .reduce((previous, current) -> current)
                        .get().getKey(); //throws exception if there is not same rank cards with specified count

                return allCards.stream()
                        .filter(c -> c.getRank() == cardsRank)
                        .collect(toList());
            } catch (NoSuchElementException e) {
                return new ArrayList<>();
            }
        }

        private List<Card> getMultipleHighestCards(List<Card> allCards, int count) {
            List<Card> highestCards = new ArrayList<>(count);
            for (int index = 0; index < count; index++) {
                List<Card> cards = getHighestCards(allCards, HIGH_CARD);
                allCards.removeAll(cards);
                highestCards.addAll(cards);
            }
            return highestCards;
        }

        private Suit getMostPopularSuit(Map<Suit, Long> suits) {
            return suits.entrySet().stream()
                    .max((lhs, rhs) -> lhs.getValue() > rhs.getValue() ? 1 : -1)
                    .get().getKey();
        }

        private EnumMap<Suit, Long> getSuitMap(List<Card> allCards) {
            return allCards.stream()
                    .collect(groupingBy(
                            Card::getSuit,
                            () -> new EnumMap<>(Suit.class),
                            counting()
                    ));
        }

        private EnumMap<Rank, Long> getRankMap(List<Card> allCards) {
            return allCards.stream()
                    .collect(groupingBy(
                            Card::getRank,
                            () -> new EnumMap<>(Rank.class),
                            counting()
                    ));
        }
    }

    public class Card implements Comparable {

        private final Rank rank;
        private final Suit suit;

        public Card(Rank rank, Suit suit) {
            this.rank = rank;
            this.suit = suit;
        }

        public Rank getRank() {
            return rank;
        }

        public Suit getSuit() {
            return suit;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "rank=" + rank +
                    ", suit=" + suit +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) return 0;
            if (o == null || getClass() != o.getClass()) return 0;

            Card card = (Card) o;

            if (rank.getValue() > card.rank.getValue()) return -1;
            if (rank.getValue() < card.rank.getValue()) return 1;
            return 0;
        }

    }

    public class PokerHand implements Comparable {
        private final HandRank handRank;
        private final List<Card> cards;

        public PokerHand(HandRank handRank, List<Card> cards) {
            if (cards.size() != HandRankCounter.FULL_HAND)
                throw new IllegalArgumentException("You have to pass five cards");
            this.handRank = handRank;
            this.cards = cards;
            Collections.sort(this.cards); //sorts for compareTo method
        }

        @Override
        public String toString() {
            return "HandValue{" +
                    "handRank=" + handRank +
                    ", allCards=" + cards +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (this == o) return 0;
            if (o == null || getClass() != o.getClass()) return 0;

            PokerHand pokerHand = (PokerHand) o;

            if (handRank.getValue() > pokerHand.handRank.getValue()) return 1;
            if (handRank.getValue() < pokerHand.handRank.getValue()) return -1;

            for (int index = 0; index < cards.size(); index++) {
                if (cards.get(index).getRank().getValue() > pokerHand.cards.get(index).getRank().getValue()) return 1;
                if (cards.get(index).getRank().getValue() < pokerHand.cards.get(index).getRank().getValue()) return -1;
            }
            return 0;
        }


    }
}

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] components = sc.nextLine().split(" ");
        String[] hand1 = new String[5];
        String[] hand2 = new String[5];
        for (int i = 0; i < 10; i++) {
            if (i < 5) hand1[i] = components[i];
            else hand2[i - 5] = components[i];
        }

        int winner = Solution.determine_winner(hand1, hand2);
        System.out.printf("Player %d wins", winner);
    }
}