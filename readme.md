```mermaid
flowchart TD

%% 프론트엔드 영역
subgraph FE [프론트엔드]
    A1["Open WebUI"]
    A2["사용자 입력"]
    A3["Open WebUI 렌더링"]
    A4["미리보기 CSV 출력"]
end

%% 백엔드 영역
subgraph BE [백엔드]
    B1["자연어 명령 해석 (llm.py)"]
    B2["툴 선택 실행 (processor.py)"]
    B3["전처리 모듈 호출 (preprocessing.py)"]
    B4["출력 포맷 변환 (format.py)"]
end

%% 백그라운드 영역
subgraph BG [백그라운드]
    C2["전체 데이터 후처리 (processor.py)"]
    C3["MinIO 업로드"]
end

%% 흐름 연결
A1 --> A2
A2 -->|FastAPI 요청| B1
B1 -->|툴 선택| B2
B2 --> B3
B3 -->|결과 생성| B4
B4 --> A3
A3 --> A4
B4 -->|백그라운드로 전달| C2
C2 --> C3
```
