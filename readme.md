```mermaid
flowchart TD

%% 영역 구분
subgraph FE [Front-end]
    A1[Open WebUI]
    A2[User Input]
    A3[Open WebUI (Render)]
    A4[Streaming Preview (CSV)]
end

subgraph BE [Back-end]
    B1[Natural Language Processing (llm.py)]
    B2[Select Tool Execution (processor.py)]
    B3[Preprocessing Module (**_preprocessing.py)]
    B4[Output Formatting (format.py)]
end

subgraph BG [Background]
    C1[Background]
    C2[Additional Data Processing (processor.py)]
    C3[MinIO Upload]
end

%% 연결
A1 --> A2
A2 -->|FastAPI| B1
B1 -->|Select Tool| B2
B2 --> B3
B3 -->|Output| B4
B4 --> A3
A3 --> A4
B4 -->|Send to background| C2
C1 --> C2 --> C3
```
