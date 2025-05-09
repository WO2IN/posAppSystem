``` mermaid
graph TD
    A[connect_minio()] --> B[minio.csv_to_df()]
    B --> C{Trace 파일인가?}
    C -->|Yes| D[header=2, skiprows=3]
    C -->|No| E[header=0]
    D & E --> F[Timestamp 컬럼 표준화 및 datetime 변환]
    F --> G[save_metadata()]
    G --> H[cut_file()]
    H -->|정상| I[minio.df_upload()]
    H -->|에러 발생| J[handle_parser_error()]
    J --> K[앞 부분 저장 _1.csv]
    J --> L[뒷 부분 저장 _2.csv]
    G --> M[group_by_date()]
    M --> N[save_group_by_date()]
    G --> O[split_by_step()]
    O --> P[save_split_by_step()]
    O --> Q[group_by_step()]
    Q --> R[save_group_by_step()]
    F --> S[extract_columns()]
    S --> T[save_extract_columns()]
```
