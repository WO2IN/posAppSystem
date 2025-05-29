```mermaid
graph TD
    A[Open-WebUI] --> B[사용자 입력]
    B --> C[자연어 해석 (Llama 3.3)]
    C --> D[AI가 툴 실행<br/>(LangChain TOOLS)]
    D --> E[미리보기 CSV 출력<br/>(나머지는 BackGround 처리)]

    %% 실패 및 결과 루프
    D -- 툴 선택 실패 --> A
    E -- 미리보기 CSV 출력 --> A
```
