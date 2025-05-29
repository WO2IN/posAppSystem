```mermaid
graph TD
    A[Open-WebUI]
    B[사용자 입력]
    C[자연어 해석 (Llama 3.3)]
    D[AI가 툴 실행 (LangChain TOOLS)]
    E[미리보기 CSV 출력 (나머지는 BackGround 처리)]

    A --> B
    B --> C
    C --> D
    D --> E
    D --> A %% 툴 선택 실패
    E --> A %% 미리보기 CSV 출력
```
