```mermaid
graph LR

%% 사용자 입력
A1[사용자 입력\n(Open WebUI)] --> A2[LLM이 입력 해석]

%% 일반 대화 흐름
A2 -->|일반 채팅| B1[응답 생성\n(GPT 방식)]
B1 --> B2[Open WebUI에 출력]

%% 전처리 흐름
A2 -->|EV 전처리 요청| C1[전처리 LLM에게 명령 전달]
C1 --> C2[명령 재해석 및 함수 매핑]
C2 --> C3[전처리 함수 실행\n(FastAPI/processor.py)]
C3 --> C4[전처리 결과 반환\n(JSON)]
C4 --> C5[Open WebUI에 출력]

```
