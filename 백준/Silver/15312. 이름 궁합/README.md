# [Silver V] 이름 궁합 - 15312 

[문제 링크](https://www.acmicpc.net/problem/15312) 

### 성능 요약

메모리: 128880 KB, 시간: 268 ms

### 분류

구현, 문자열

### 제출 일자

2025년 7월 4일 15:36:59

### 문제 설명

<p><em>'이름 궁합'</em>이란 두 사람의 이름을 한 글자씩 번갈아 써 놓고 획수를 그 아래에 적은 뒤, 인접한 숫자끼리 더한 일의 자리 값을 아래에 적어 나가면서 마지막에 남은 두 숫자를 보고 궁합이 맞는 정도를 알아보는 일종의 점이다.</p>

<p>아직도 <em>'그녀'</em>를 잊지 못한 로맨티스트 종민이는 어느 날 그녀와 이름 궁합을 한 번 해 보기로 했는데, 그 결과는 충격적이었다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/15312/1.jpg" style="height:314px; width:350px"></p>

<p>이 결과를 도저히 받아들일 수 없었던 종민이는 이것이 틀렸음을 증명하기 위해 열심히 머리를 굴렸고, 다음과 같은 변명거리를 생각해 냈다.</p>

<p><em>"'그녀'는 한국인이 아니니까 한글로 이름 궁합을 보면 결과가 이상한 것이 당연하지! 세계 공용어인 영어 알파벳으로 이름을 쓰면 결과가 정확하게 나올 거야!"</em></p>

<p>그래서 종민이는 알파벳 대문자로 이름을 써 놓고 이름 궁합을 보려고 한다. 그런데, 종민이는 손으로 계산을 하면 실수를 할까 두려워 당신에게 프로그램을 짜 달라고 부탁했다. 종민이를 도와주자! 종민이가 정한 알파벳 대문자의 획수는 <strong>힌트</strong>를 참고하자.</p>

### 입력 

 <p>첫 번째 줄에는 종민이의 영어 이름 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D434 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>A</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$A$</span></mjx-container>가 주어진다. </p>

<p>두 번째 줄에는 '그녀'의 영어 이름 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D435 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>B</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$B$</span></mjx-container>가 주어진다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D434 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>A</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$A$</span></mjx-container>와 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D435 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>B</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$B$</span></mjx-container> 모두 알파벳 대문자로만 이루어진 길이 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2$</span></mjx-container> 이상 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>2</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$2\, 000$</span></mjx-container> 이하의 문자열이며, 둘의 길이가 같음이 보장된다. 이름 궁합을 볼 때는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D434 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>A</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$A$</span></mjx-container>의 첫 글자를 먼저 쓴다고 하자.</p>

### 출력 

 <p>이름 궁합의 결과를 두 자리의 숫자로 출력한다. (십의 자리가 0이어도 두 자리로 출력한다)</p>

