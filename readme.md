```mermaid
flowchart LR
    subgraph WEB
        A1[Open WebUI] --> A2[사용자 입력]
    end

    subgraph BACKEND
        B1[자연어 명령 해석 및 툴 선택<br>(llm.py)]
        B2[선택된 Tool 실행<br>(processor.py)]
    end

    A2 -->|FastAPI| B1 --> B2
```
