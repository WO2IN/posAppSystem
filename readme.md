# 데이터 전처리 프로그램 통합 모듈

<br>

## 📌 data_manage 모듈
### [모듈 종류]

```python
get_csv_files_by_folder(input_folder) # 주어진 로컬 폴더에서 CSV 파일 리스트를 반환

# input_folder(String): 불러올 파일 경로
```

```python
save_dataframe_to_csv(dataframe, output_path, append=False) # 데이터프레임을 CSV로 로컬에 저장

# dataframe(pd.DataFrame): 처리할 데이터프레임
# ouput_path(String): 저장할 파일 경로
```

```python
set_outliers_to_nan(df, column_ranges) # 규격에 맞게 이상치 값 NaN값으로 처리

# df(pd.DataFrame): 처리할 데이터프레임
# column_ranges(dict): 처리할 데이터와 규격 설정 (ex. column_ranges = {'필드명': (min, max)} )
```
