```mermaid
flowchart TD

%% Front-end 영역
subgraph FE [Front-end]
    A1["Open WebUI"]
    A2["사용자 입력"]
    A3["Open WebUI 데이터 출력"]
    A4["Streamlit 데이터 시각화"]
end

%% Back-end 영역
subgraph BE [Back-end]
    B1["자연어 명령 해석 (llm.py)"]
    B2["툴 실행 (processor.py)"]
    B3["전처리 모듈 호출 (preprocessing.py)"]
    B4["출력 포맷 변환 (format.py)"]
end

%% Back-ground 영역
subgraph BG [Back-ground]
    C2["전체 데이터 후처리 (processor.py)"]
    C3["MinIO 업로드"]
end

%% 흐름 연결
A1 --> A2
A2 -->|FastAPI 요청| B1
B1 -->|LLM기반 툴 선택| B2
B2 --> B3
B3 -->|결과 반환| B4
B4 --> A3
A3 --> |CSV File| A4
B2 -->|백그라운드로 전달| C2
C2 --> C3
