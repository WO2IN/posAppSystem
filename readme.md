# **Betterwhy Section_Statistics (구간 통계 추출)**
<br>

## ⚠️ 주의사항 
1. **원본 데이터 전처리 작업**(`bw_origin_preproc`),

2. **충전 및 방전 구간 분류 작업**(`bw_classify_section`) 후 실행할 것.

<br>

## ✅ Betterwhy 입력 데이터
```
[ 'CLIENTID', 'TIMESTAMP', 'CAR_TYPE', 'SOH', 'PACK_V', 'CURRENT', 'SOC',
      'DCH_SAC', 'CHG_SAC', 'TEMPERATURE1', 'TEMPERATURE2', 'TEMPERATURE3', 'TEMPERATURE4',
      'TEMPERATURE5', 'MILEAGE', 'MODEL_YEAR', 'MODEL_MONTH'] 
      + ['CELL' + str(n) for n in range(1,201)]
```

## ✅ Betterwhy 출력 데이터
| **필드명**                    | **항목명**                         | **필드명**                       | **항목명**                           |
|---------------------------|------------------------------------|------------------------------|------------------------------------|
| `car_id`                  | **차량id**                         | `period`              | **구간 기간(초)**                           |
| `car_type`                    | **차종**                       | `charge_discharge_speed`    | **1시간당 SOC 충방전 속도**           |
| `charge_type`          | **충전/방전 타입**                      | `power_quan`          | **소모/충전 전력 량**                       |
| `start_time`           | **구간 시작시간**                       | `power_per_hour` | **1시간당 소모/충전된 전력량**                   |
| `end_time`            | **구간 끝 시간**                         | `power_per_soc`| **SOC 1%당 소모/충전된 전력량**                    |
| `soh`                | **soh 평균**                              | `module_temp`         | **모듈 1~4 평균 온도**                      |
| `p_volt`            | **팩 전압 평균**                           | `temperature`                  | **기온 평균**                      |
| `p_current`            | **팩 전류 평균**                        | `mileage`              | **구간 주행거리**                          |
| `cell_volt_diff`| **셀 최대/최소 전압차 평균**                   | `accum_mileage`              | **누적 주행거리**                    |
| `soc_start`             | **soc 시작 값**                        | `km_per_kWh`                       | **전비**                       |
| `soc_end`               | **soc 끝 값**                          | `model_year`                   | **연식(년)**                       |
| `soc_quan`          | **soc 충/방전 량**                         | `model_month`                   | **연식(월)**                      |


<br>

## 🌐 데이터 입력 / 출력 경로
| 데이터 종류 | 데이터 입력 위치 | 데이터 저장 위치 |
|-|-|-|
|Betterwhy(Local)|$ rsync -avhz -e 'ssh -p 9990' --progress --partial data@59.14.241.229:/home/data/hdd_new/betterwhy_data/betterwhy_origin 저장할 경로<br>[pw : evdataset1234!]| /
|Betterwhy(MinIO)|keti-ev-data/betterwhy_data/betterwhy_origin|tmp/preproc

<br><br>


# 📊 실행 결과
<div>
<table class="dataframe" border="1">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>car_id</th>
      <th>car_type</th>
      <th>charge_type</th>
      <th>start_time</th>
      <th>end_time</th>
      <th>soh</th>
      <th>p_volt</th>
      <th>p_current</th>
      <th>cell_volt_diff</th>
      <th>soc_start</th>
      <th>soc_end</th>
      <th>soc_quan</th>
      <th>period</th>
      <th>charge_discharge_speed</th>
      <th>power_quan</th>
      <th>power_per_hour</th>
      <th>power_per_soc</th>
      <th>module_temp</th>
      <th>temperature</th>
      <th>mileage</th>
      <th>accum_mileage</th>
      <th>km_per_kWh</th>
      <th>speed_0</th>
      <th>speed_0_30</th>
      <th>speed_30_60</th>
      <th>speed_60_90</th>
      <th>speed_90_180</th>
      <th>model_year</th>
      <th>model_month</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>V004AK0001</td>
      <td>EV6_LONGRANGE</td>
      <td>discharge</td>
      <td>2023-12-13 19:00:39.114000</td>
      <td>2023-12-13 19:41:44.784000</td>
      <td>100.0</td>
      <td>693.437500</td>
      <td>-9.946238</td>
      <td>0.006214</td>
      <td>41.5</td>
      <td>36.0</td>
      <td>5.5</td>
      <td>2465.670</td>
      <td>8.030272</td>
      <td>9.399902</td>
      <td>13.724322</td>
      <td>1.709073</td>
      <td>13.419600</td>
      <td>NaN</td>
      <td>28.0</td>
      <td>42280.0</td>
      <td>2.978754</td>
      <td>180.0</td>
      <td>225.0</td>
      <td>112.0</td>
      <td>193.0</td>
      <td>100.0</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>V004AK0001</td>
      <td>EV6_LONGRANGE</td>
      <td>discharge</td>
      <td>2023-12-17 05:51:47.948000</td>
      <td>2023-12-17 06:16:12.855000</td>
      <td>100.0</td>
      <td>680.541515</td>
      <td>-14.060327</td>
      <td>0.019223</td>
      <td>30.5</td>
      <td>25.5</td>
      <td>5.0</td>
      <td>1464.907</td>
      <td>12.287469</td>
      <td>7.399902</td>
      <td>18.185215</td>
      <td>1.479980</td>
      <td>0.914622</td>
      <td>NaN</td>
      <td>14.0</td>
      <td>42544.0</td>
      <td>1.891917</td>
      <td>125.0</td>
      <td>115.0</td>
      <td>87.0</td>
      <td>134.0</td>
      <td>15.0</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>V004AK0001</td>
      <td>EV6_LONGRANGE</td>
      <td>discharge</td>
      <td>2023-12-18 18:59:39.994000</td>
      <td>2023-12-18 19:50:07.481000</td>
      <td>100.0</td>
      <td>749.309686</td>
      <td>-11.091096</td>
      <td>0.014149</td>
      <td>80.5</td>
      <td>72.5</td>
      <td>8.0</td>
      <td>3027.487</td>
      <td>9.512840</td>
      <td>12.700195</td>
      <td>15.101866</td>
      <td>1.587524</td>
      <td>2.311399</td>
      <td>NaN</td>
      <td>34.0</td>
      <td>42643.0</td>
      <td>2.677124</td>
      <td>269.0</td>
      <td>164.0</td>
      <td>238.0</td>
      <td>300.0</td>
      <td>40.0</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>V004AK0001</td>
      <td>EV6_LONGRANGE</td>
      <td>discharge</td>
      <td>2023-12-15 06:06:47.087000</td>
      <td>2023-12-15 06:39:04.602000</td>
      <td>100.0</td>
      <td>746.728162</td>
      <td>-10.436145</td>
      <td>0.008404</td>
      <td>75.5</td>
      <td>70.5</td>
      <td>5.0</td>
      <td>1937.515</td>
      <td>9.290251</td>
      <td>8.699707</td>
      <td>16.164492</td>
      <td>1.739941</td>
      <td>13.481175</td>
      <td>NaN</td>
      <td>28.0</td>
      <td>42401.0</td>
      <td>3.218499</td>
      <td>80.0</td>
      <td>95.0</td>
      <td>178.0</td>
      <td>285.0</td>
      <td>26.0</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>4</th>
      <td>V004AK0001</td>
      <td>EV6_LONGRANGE</td>
      <td>discharge</td>
      <td>2023-12-17 17:49:58.113000</td>
      <td>2023-12-17 18:46:13.592000</td>
      <td>100.0</td>
      <td>784.339964</td>
      <td>-6.579222</td>
      <td>0.014624</td>
      <td>96.0</td>
      <td>91.0</td>
      <td>5.0</td>
      <td>3375.479</td>
      <td>5.332577</td>
      <td>9.200195</td>
      <td>9.812149</td>
      <td>1.840039</td>
      <td>12.133289</td>
      <td>NaN</td>
      <td>20.0</td>
      <td>42568.0</td>
      <td>2.173867</td>
      <td>409.0</td>
      <td>321.0</td>
      <td>278.0</td>
      <td>74.0</td>
      <td>14.0</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>...</th>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
    <tr>
      <th>166</th>
      <td>V018AL0000</td>
      <td>NIRO2</td>
      <td>slow_charge</td>
      <td>2023-12-16 20:20:55.355000</td>
      <td>2023-12-17 08:21:48.610000</td>
      <td>100.0</td>
      <td>365.613052</td>
      <td>6.771642</td>
      <td>0.009045</td>
      <td>31.5</td>
      <td>71.0</td>
      <td>39.5</td>
      <td>43253.255</td>
      <td>3.287614</td>
      <td>75.402344</td>
      <td>6.275792</td>
      <td>1.908920</td>
      <td>0.757126</td>
      <td>NaN</td>
      <td>0.0</td>
      <td>66032.0</td>
      <td>0.000000</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>2022.0</td>
      <td>7.0</td>
    </tr>
    <tr>
      <th>167</th>
      <td>V007AJ0000</td>
      <td>NIRO_LONGRANGE</td>
      <td>slow_charge</td>
      <td>2023-12-13 22:15:55.193000</td>
      <td>2023-12-14 07:42:14.338000</td>
      <td>100.0</td>
      <td>374.223057</td>
      <td>6.047955</td>
      <td>0.005774</td>
      <td>46.5</td>
      <td>75.5</td>
      <td>29.0</td>
      <td>33979.145</td>
      <td>3.072473</td>
      <td>55.101562</td>
      <td>5.837864</td>
      <td>1.900054</td>
      <td>13.946650</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>2018.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>168</th>
      <td>TESTEV9</td>
      <td>EV9</td>
      <td>slow_charge</td>
      <td>2023-12-15 15:58:09.527000</td>
      <td>2023-12-16 03:58:49.183000</td>
      <td>100.0</td>
      <td>571.426632</td>
      <td>10.619696</td>
      <td>0.006633</td>
      <td>14.0</td>
      <td>80.0</td>
      <td>66.0</td>
      <td>43239.656</td>
      <td>5.494956</td>
      <td>124.199951</td>
      <td>10.340504</td>
      <td>1.881817</td>
      <td>10.192229</td>
      <td>NaN</td>
      <td>0.0</td>
      <td>4818.0</td>
      <td>0.000000</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>2023.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>169</th>
      <td>V011AK0000</td>
      <td>PORTER2</td>
      <td>slow_charge</td>
      <td>2023-12-18 15:02:22.852000</td>
      <td>2023-12-19 03:07:54.756000</td>
      <td>100.0</td>
      <td>347.698212</td>
      <td>11.753045</td>
      <td>0.006736</td>
      <td>24.0</td>
      <td>94.0</td>
      <td>70.0</td>
      <td>43531.904</td>
      <td>5.788858</td>
      <td>132.900391</td>
      <td>10.990592</td>
      <td>1.898577</td>
      <td>5.884353</td>
      <td>NaN</td>
      <td>0.0</td>
      <td>31121.0</td>
      <td>0.000000</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>2022.0</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>170</th>
      <td>SITESTKONA</td>
      <td>KONA_LONGRANGE</td>
      <td>slow_charge</td>
      <td>2023-12-15 13:17:21.309000</td>
      <td>2023-12-16 06:48:21.327000</td>
      <td>100.0</td>
      <td>377.702393</td>
      <td>7.210375</td>
      <td>0.004986</td>
      <td>27.0</td>
      <td>94.5</td>
      <td>67.5</td>
      <td>63060.018</td>
      <td>3.853472</td>
      <td>129.799805</td>
      <td>7.410072</td>
      <td>1.922960</td>
      <td>10.083012</td>
      <td>NaN</td>
      <td>0.0</td>
      <td>94515.0</td>
      <td>0.000000</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>2023.0</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
<p>171 rows × 29 columns</p>
</div>
