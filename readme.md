```mermaid
graph TD
A[Open-WebUI] --> B[사용자 입력]
B --> C[자연어 해석 (Llama 3.3)]
C --> D[AI가 툴 실행 (LangChain TOOLS)]
D --> E[미리보기 CSV 출력 (나머지는 BackGround 처리)]
D --> F[툴 선택 실패]
E --> G[미리보기 CSV 출력 완료]
F --> A
G --> A

```
