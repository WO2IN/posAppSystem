```mermaid
graph LR;
    Main --> |LLM 모델이 질문 이해|LLM[LLM]
    
    LLM --> 전처리 AI 모델에 입력값 전달

    input/output --> preproc_select[전처리 과정 선택]
    input/output --> |이전 화면 선택|Main

    preproc_select --> origin_preproc[원본 데이터 전처리 작업]
```

### 📌 전처리 로직
- ✅

### 📌 AI 모델
- ✅

### 📌 서버 
- ✅

