<div class="margin-t-3"><h3><span>作业内容</span></h3><div class="margin-t-2 mark-down-wrap"><div class="markdown-body markdown-init "><h2><!-- react-text: 178 -->中文版<!-- /react-text --></h2><p><!-- react-text: 180 -->一副扑克有52张牌，每张牌由一个花色和一个数字构成。<!-- /react-text --></p><p><!-- react-text: 182 -->花色为以下四者之一：<!-- /react-text --></p><pre><code class="hljs">方片 D
黑桃 S
红桃 H
梅花 C</code></pre><p><!-- react-text: 186 -->数字为以下13者之一，且大小顺序如下：<!-- /react-text --></p><pre><code class="hljs">2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A</code></pre><p><!-- react-text: 190 -->花色是大小无序的，但数字有序，2最小，A最大。<!-- /react-text --></p><p><!-- react-text: 192 -->一手牌有5张。根据花色和数字的不同，其大小按照以下规则决定。<!-- /react-text --></p><p><!-- react-text: 194 -->满足下面规则的手牌会大于满足上面规则的手牌。<!-- /react-text --></p><pre><code class="hljs">同花顺＞铁支＞葫芦＞同花＞顺子＞三条＞两对＞对子＞散牌</code></pre><ol><li><p><!-- react-text: 200 -->散牌：<!-- /react-text --></p><p><!-- react-text: 202 -->不符合其他任何规则的五张牌。
比较最大一张牌的大小，如果相同，比较第二大的牌的牌点数，如果五张牌的牌点数都相同，则为平局。<!-- /react-text --></p></li><li><p><!-- react-text: 205 -->对子：<!-- /react-text --></p><p><!-- react-text: 207 -->有两张同样大小的牌片。
比较两张大小一样的牌的牌点数，如果相同，依次比较剩余的三张牌大小。若大小都相同，则为平局。<!-- /react-text --></p></li><li><p><!-- react-text: 210 -->两对：<!-- /react-text --></p><p><!-- react-text: 212 -->有两个对子牌。
比较大对子的大小，若相同，比较小对子的大小，若还相同，比较单张牌的大小，若还相同，则为平局。<!-- /react-text --></p></li><li><p><!-- react-text: 215 -->三条：<!-- /react-text --></p><p><!-- react-text: 217 -->有三张同样大小的牌片。
比较三张大小一样的牌的牌点数大小。<!-- /react-text --></p></li><li><p><!-- react-text: 220 -->顺子：<!-- /react-text --></p><p><!-- react-text: 222 -->五张相连的牌。
比较最大的牌点数。若大小都相同，则为平局。<!-- /react-text --></p></li><li><p><!-- react-text: 225 -->同花：<!-- /react-text --></p><p><!-- react-text: 227 -->五张牌的花色相同。
按照散排规则比较大小。<!-- /react-text --></p></li><li><p><!-- react-text: 230 -->葫芦：<!-- /react-text --></p><p><!-- react-text: 232 -->三条+对子。
比较三张大小一样的牌的牌点数。<!-- /react-text --></p></li><li><p><!-- react-text: 235 -->铁支：<!-- /react-text --></p><p><!-- react-text: 237 -->有四张同样大小的牌片。
比较四张大小一样的牌的牌点数。<!-- /react-text --></p></li><li><p><!-- react-text: 240 -->同花顺：<!-- /react-text --></p><p><!-- react-text: 242 -->同一种花色的顺子。
比较最大的牌的牌的大小。若大小都相同，则为平局。<!-- /react-text --></p></li></ol><p><!-- react-text: 244 -->你的工作是为两手牌判断大小。<!-- /react-text --></p><p><!-- react-text: 246 -->例如：<!-- /react-text --></p><p><!-- react-text: 248 -->输入: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 250 --> White: <!-- /react-text --><code>2C 3H 4S 8C AH</code><!-- react-text: 252 -->
输出: 
White wins<!-- /react-text --></p><p><!-- react-text: 254 -->输入: 
Black: <!-- /react-text --><code>2H 4S 4C 2D 4H</code><!-- react-text: 256 --> White: <!-- /react-text --><code>2S 8S AS QS 3S</code><!-- react-text: 258 -->
输出: 
Black wins <!-- /react-text --></p><p><!-- react-text: 260 -->输入: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 262 --> White: <!-- /react-text --><code>2C 3H 4S 8C KH</code><!-- react-text: 264 -->
输出: 
Black wins <!-- /react-text --></p><p><!-- react-text: 266 -->输入: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 268 --> White: <!-- /react-text --><code>2D 3H 5C 9S KH</code><!-- react-text: 270 -->
输出: 
Tie<!-- /react-text --></p><h2><!-- react-text: 272 -->English version<!-- /react-text --></h2><p><!-- react-text: 274 -->A poker deck contains 52 cards - each card has a suit which
is one of clubs, diamonds, hearts, or spades 
(denoted C, D, H, and S in the input data). <!-- /react-text --></p><p><!-- react-text: 276 -->Each card also has a value which is one of 
2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, king, ace 
(denoted 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A). <!-- /react-text --></p><p><!-- react-text: 278 -->For scoring purposes, the suits are unordered while the
values are ordered as given above, with 2 being the lowest
and ace the highest value.<!-- /react-text --></p><p><!-- react-text: 280 -->A poker hand consists of 5 cards dealt from the deck. Poker
hands are ranked by the following partial order from lowest
to highest.<!-- /react-text --></p><p><!-- react-text: 282 -->High Card: Hands which do not fit any higher category are
ranked by the value of their highest card. If the highest
cards have the same value, the hands are ranked by the next
highest, and so on.<!-- /react-text --></p><p><!-- react-text: 284 -->Pair: 2 of the 5 cards in the hand have the same value. 
Hands which both contain a pair are ranked by the value of
the cards forming the pair. If these values are the same, 
the hands are ranked by the values of the cards not 
forming the pair, in decreasing order.<!-- /react-text --></p><p><!-- react-text: 286 -->Two Pairs: The hand contains 2 different pairs. Hands 
which both contain 2 pairs are ranked by the value of 
their highest pair. Hands with the same highest pair 
are ranked by the value of their other pair. If these 
values are the same the hands are ranked by the value 
of the remaining card.<!-- /react-text --></p><p><!-- react-text: 288 -->Three of a Kind: Three of the cards in the hand have the 
same value. Hands which both contain three of a kind are 
ranked by the value of the 3 cards.<!-- /react-text --></p><p><!-- react-text: 290 -->Straight: Hand contains 5 cards with consecutive values. 
Hands which both contain a straight are ranked by their 
highest card.<!-- /react-text --></p><p><!-- react-text: 292 -->Flush: Hand contains 5 cards of the same suit. Hands which 
are both flushes are ranked using the rules for High Card.<!-- /react-text --></p><p><!-- react-text: 294 -->Full House: 3 cards of the same value, with the remaining 2
cards forming a pair. Ranked by the value of the 3 cards.<!-- /react-text --></p><p><!-- react-text: 296 -->Four of a kind: 4 cards with the same value. Ranked by the
value of the 4 cards.<!-- /react-text --></p><p><!-- react-text: 298 -->Straight flush: 5 cards of the same suit with consecutive
values. Ranked by the highest card in the hand.<!-- /react-text --></p><p><!-- react-text: 300 -->Your job is to rank pairs of poker hands and to indicate
which, if either, has a higher rank.<!-- /react-text --></p><p><!-- react-text: 302 -->Examples:<!-- /react-text --></p><p><!-- react-text: 304 -->Input: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 306 --> White: <!-- /react-text --><code>2C 3H 4S 8C AH</code><!-- react-text: 308 -->
Output: 
White wins - high card: Ace <!-- /react-text --></p><p><!-- react-text: 310 -->Input: 
Black: <!-- /react-text --><code>2H 4S 4C 2D 4H</code><!-- react-text: 312 --> White: <!-- /react-text --><code>2S 8S AS QS 3S</code><!-- react-text: 314 -->
Output: 
Black wins - full house<!-- /react-text --></p><p><!-- react-text: 316 -->Input: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 318 --> White: <!-- /react-text --><code>2C 3H 4S 8C KH</code><!-- react-text: 320 -->
Output: 
Black wins - high card: 9<!-- /react-text --></p><p><!-- react-text: 322 -->Input: 
Black: <!-- /react-text --><code>2H 3D 5S 9C KD</code><!-- react-text: 324 --> White: <!-- /react-text --><code>2D 3H 5C 9S KH</code><!-- react-text: 326 -->
Output: 
Tie<!-- /react-text --></p></div></div><div class="margin-t-2"><a><span>题目有错误 ?</span></a><!-- react-text: 60 --><!-- /react-text --></div></div>