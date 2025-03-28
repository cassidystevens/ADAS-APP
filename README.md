ADAS App Development
--------------------------------
We designed a basic Android application with the following requirements:
- showcase categories such as Acceleration and Braking Patterns, Cornering Behavior, Speed Consistency, Lane Changes and Drifts, and Wearable Device Metrics
- display the raw data values from each source for every category (based on the breakdown below)
  
Categories
---------------------------------
1. Acceleration and Braking Patterns:
    - Data Source: Accelerometers and gyroscopes in various smartphone brands.
    - Purpose: To measure forcefulness and smoothness in acceleration and braking, identifying aggressive or unsafe driving behaviors.
  
2. Cornering Behavior:
    - Data Source: Gyroscopes and GPS across different smartphones.
    - Purpose: Assessing the manner of taking corners. Sharp cornering can indicate risky driving.
  
3. Speed Consistency:
    - Data Source: GPS functionality in diverse smartphones.
    - Purpose: Monitoring vehicle speed relative to road types and traffic conditions, identifying speed fluctuations.
  
4. Lane Changes and Drifts:
    - Data Source: Accelerometers and gyroscopes in various smartphones.
    - Purpose: Detecting frequency and smoothness of lane changes to suggest attentive or inattentive driving.
  
5. Wearable Device Metrics if available:
    - Heart Rate Variability (HRV) and Stress Level:
      - Data Source: A range of wearable devices capable of measuring HRV.
      - Purpose: To monitor the driver's stress level, influencing driving behavior.
    - Respiratory Rate:
      - Data Source: Various wearables with respiratory rate tracking.
      - Purpose: To observe breathing patterns, correlating with stress or fatigue levels.
    - Environmental and Contextual Metrics
      - Time of Day and Day of Week:
        - Purpose: Understanding variations in driving patterns across different times and days.
      - Weather Conditions:
        - Data Integration: Utilizing weather data APIs.
        - Purpose: Correlating driving behavior with varying weather conditions.
      - Traffic Conditions:
        - Data Integration: Using real-time traffic data sources.
        - Purpose: Analyzing driving behavior in diverse traffic scenarios.
      - Road Type and Conditions:
        - Data Integration: From various map and terrain databases.
        - Purpose: Assessing driving appropriateness for different road types and conditions.

Team and Contributions:
---------------------------------
- Cassidy Stevens: Created the basic structure of the app and the various pages for displaying the data.
- Fardeen Bhimani: Populated section 5 and its subcategories with data and created a demo video for the app.
- Mindy Cha: Made improvements to the app and populated sections 1-4 of the app with data.
