# EV_PROCESSING 

<br>

## 📌 ev_preprocessing 모듈
[모듈 종류]

```python
set_outliers_to_nan(df, column_ranges) 
# 기능: 규격에 맞게 이상치 값 NaN값으로 처리

# df(pd.DataFrame): 처리할 데이터프레임
# column_ranges(dict): 처리할 데이터와 규격 설정 (ex. column_ranges = {'필드명': (min, max)} 

# ✅ 필드명: 대소문자 구분 X, 필드명을 정확히 입력하거나, cell_1 ~ cell_180 ← 이런 필드명 같은 경우 숫자 전까지만 입력 (ex. cell_  
```

```python
save_outliers_meta(file_name, column_ranges, target_tot_rows, valid_count, nan_count, processed_by=os.geteuid())
# 기능
주어진 파일의 이상치(Outlier) 처리 정보를 JSON 형식으로 변환하여 반환합니다.

# 입력값
- `file_name` (str): 처리 대상 CSV 파일의 이름
- `column_ranges` (dict): 컬럼별 데이터 범위 조건
- `target_tot_rows` (int): `column_ranges`에 포함된 컬럼의 총 데이터 개수
- `valid_count` (dict): 컬럼별 유효한 데이터 개수
- `nan_count` (dict): 컬럼별 이상치로 처리된 개수
- `processed_by` (int, 기본값: `os.geteuid()`): 데이터 처리자의 ID

# 출력값
- `json_data` (dict): 이상치 처리 정보를 포함한 JSON 형식의 데이터
```
