```mermaid
graph TD
A[Open-WebUI]
B[사용자 입력]
C[자연어 해석 (Llama 3.3)]
D[명령어 기반 함수 선택 (LangChain TOOLS)]
E[선택된 툴 실행 (processor.py)]
F[결과 생성 (format.py에 전달)]
G[포맷된 문자열 반환 (main.py)]
H[출력 - Open-WebUI]
Z[요청 실패 처리 → 사용자 안내]

A --> B
B --> C
C --> D
D --> E
E --> F
F --> G
G --> H
H --> A
D --> Z
Z --> A
```
