package com.brighamdiaz.weathery.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Brigham on 11/27/2016.
 *
 * POJO for Yahoo API forecast
 */
public class Forecast implements Serializable {
    public class Results {
        public class Channel {
            public class Location {

                private String city;
                private String country;
                private String region;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The city
                 */
                public String getCity() {
                    return city;
                }

                /**
                 *
                 * @param city
                 *     The city
                 */
                public void setCity(String city) {
                    this.city = city;
                }

                /**
                 *
                 * @return
                 *     The country
                 */
                public String getCountry() {
                    return country;
                }

                /**
                 *
                 * @param country
                 *     The country
                 */
                public void setCountry(String country) {
                    this.country = country;
                }

                /**
                 *
                 * @return
                 *     The region
                 */
                public String getRegion() {
                    return region;
                }

                /**
                 *
                 * @param region
                 *     The region
                 */
                public void setRegion(String region) {
                    this.region = region;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Units {

                private String distance;
                private String pressure;
                private String speed;
                private String temperature;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The distance
                 */
                public String getDistance() {
                    return distance;
                }

                /**
                 *
                 * @param distance
                 *     The distance
                 */
                public void setDistance(String distance) {
                    this.distance = distance;
                }

                /**
                 *
                 * @return
                 *     The pressure
                 */
                public String getPressure() {
                    return pressure;
                }

                /**
                 *
                 * @param pressure
                 *     The pressure
                 */
                public void setPressure(String pressure) {
                    this.pressure = pressure;
                }

                /**
                 *
                 * @return
                 *     The speed
                 */
                public String getSpeed() {
                    return speed;
                }

                /**
                 *
                 * @param speed
                 *     The speed
                 */
                public void setSpeed(String speed) {
                    this.speed = speed;
                }

                /**
                 *
                 * @return
                 *     The temperature
                 */
                public String getTemperature() {
                    return temperature;
                }

                /**
                 *
                 * @param temperature
                 *     The temperature
                 */
                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Wind {

                private String chill;
                private String direction;
                private String speed;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The chill
                 */
                public String getChill() {
                    return chill;
                }

                /**
                 *
                 * @param chill
                 *     The chill
                 */
                public void setChill(String chill) {
                    this.chill = chill;
                }

                /**
                 *
                 * @return
                 *     The direction
                 */
                public String getDirection() {
                    return direction;
                }

                /**
                 *
                 * @param direction
                 *     The direction
                 */
                public void setDirection(String direction) {
                    this.direction = direction;
                }

                /**
                 *
                 * @return
                 *     The speed
                 */
                public String getSpeed() {
                    return speed;
                }

                /**
                 *
                 * @param speed
                 *     The speed
                 */
                public void setSpeed(String speed) {
                    this.speed = speed;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Astronomy {

                private String sunrise;
                private String sunset;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The sunrise
                 */
                public String getSunrise() {
                    return sunrise;
                }

                /**
                 *
                 * @param sunrise
                 *     The sunrise
                 */
                public void setSunrise(String sunrise) {
                    this.sunrise = sunrise;
                }

                /**
                 *
                 * @return
                 *     The sunset
                 */
                public String getSunset() {
                    return sunset;
                }

                /**
                 *
                 * @param sunset
                 *     The sunset
                 */
                public void setSunset(String sunset) {
                    this.sunset = sunset;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Atmosphere {

                private String humidity;
                private String pressure;
                private String rising;
                private String visibility;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The humidity
                 */
                public String getHumidity() {
                    return humidity;
                }

                /**
                 *
                 * @param humidity
                 *     The humidity
                 */
                public void setHumidity(String humidity) {
                    this.humidity = humidity;
                }

                /**
                 *
                 * @return
                 *     The pressure
                 */
                public String getPressure() {
                    return pressure;
                }

                /**
                 *
                 * @param pressure
                 *     The pressure
                 */
                public void setPressure(String pressure) {
                    this.pressure = pressure;
                }

                /**
                 *
                 * @return
                 *     The rising
                 */
                public String getRising() {
                    return rising;
                }

                /**
                 *
                 * @param rising
                 *     The rising
                 */
                public void setRising(String rising) {
                    this.rising = rising;
                }

                /**
                 *
                 * @return
                 *     The visibility
                 */
                public String getVisibility() {
                    return visibility;
                }

                /**
                 *
                 * @param visibility
                 *     The visibility
                 */
                public void setVisibility(String visibility) {
                    this.visibility = visibility;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Image {

                private String title;
                private String width;
                private String height;
                private String link;
                private String url;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The title
                 */
                public String getTitle() {
                    return title;
                }

                /**
                 *
                 * @param title
                 *     The title
                 */
                public void setTitle(String title) {
                    this.title = title;
                }

                /**
                 *
                 * @return
                 *     The width
                 */
                public String getWidth() {
                    return width;
                }

                /**
                 *
                 * @param width
                 *     The width
                 */
                public void setWidth(String width) {
                    this.width = width;
                }

                /**
                 *
                 * @return
                 *     The height
                 */
                public String getHeight() {
                    return height;
                }

                /**
                 *
                 * @param height
                 *     The height
                 */
                public void setHeight(String height) {
                    this.height = height;
                }

                /**
                 *
                 * @return
                 *     The link
                 */
                public String getLink() {
                    return link;
                }

                /**
                 *
                 * @param link
                 *     The link
                 */
                public void setLink(String link) {
                    this.link = link;
                }

                /**
                 *
                 * @return
                 *     The url
                 */
                public String getUrl() {
                    return url;
                }

                /**
                 *
                 * @param url
                 *     The url
                 */
                public void setUrl(String url) {
                    this.url = url;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }
            public class Item {
                public class Condition {

                    private String code;
                    private String date;
                    private String temp;
                    private String text;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    /**
                     *
                     * @return
                     *     The code
                     */
                    public String getCode() {
                        return code;
                    }

                    /**
                     *
                     * @param code
                     *     The code
                     */
                    public void setCode(String code) {
                        this.code = code;
                    }

                    /**
                     *
                     * @return
                     *     The date
                     */
                    public String getDate() {
                        return date;
                    }

                    /**
                     *
                     * @param date
                     *     The date
                     */
                    public void setDate(String date) {
                        this.date = date;
                    }

                    /**
                     *
                     * @return
                     *     The temp
                     */
                    public String getTemp() {
                        return temp;
                    }

                    /**
                     *
                     * @param temp
                     *     The temp
                     */
                    public void setTemp(String temp) {
                        this.temp = temp;
                    }

                    /**
                     *
                     * @return
                     *     The text
                     */
                    public String getText() {
                        return text;
                    }

                    /**
                     *
                     * @param text
                     *     The text
                     */
                    public void setText(String text) {
                        this.text = text;
                    }

                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }

                }

                public class ForecastData {

                    private String code;
                    private String date;
                    private String day;
                    private String high;
                    private String low;
                    private String text;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    /**
                     *
                     * @return
                     *     The code
                     */
                    public String getCode() {
                        return code;
                    }

                    /**
                     *
                     * @param code
                     *     The code
                     */
                    public void setCode(String code) {
                        this.code = code;
                    }

                    /**
                     *
                     * @return
                     *     The date
                     */
                    public String getDate() {
                        return date;
                    }

                    /**
                     *
                     * @param date
                     *     The date
                     */
                    public void setDate(String date) {
                        this.date = date;
                    }

                    /**
                     *
                     * @return
                     *     The day
                     */
                    public String getDay() {
                        return formattedDay(day);
                    }

                    private String formattedDay(String day) {
                        if(day.toUpperCase().equals("Mon")) {
                            return "Monday";
                        } else if(day.toUpperCase().contains("TUE")) {
                            return "Tuesday";
                        } else if(day.toUpperCase().contains("WED")) {
                            return "Wednesday";
                        } else if(day.toUpperCase().contains("THU")) {
                            return "Thursday";
                        } else if(day.toUpperCase().contains("FRI")) {
                            return "Friday";
                        } else if(day.toUpperCase().contains("SAT")) {
                            return "Saturday";
                        } else if(day.toUpperCase().contains("SUN")) {
                            return "Sunday";
                        }
                        return day;
                    }

                    /**
                     *
                     * @param day
                     *     The day
                     */
                    public void setDay(String day) {
                        this.day = day;
                    }

                    /**
                     *
                     * @return
                     *     The high
                     */
                    public String getHigh() {
                        return high + "°F";
                    }

                    /**
                     *
                     * @param high
                     *     The high
                     */
                    public void setHigh(String high) {
                        this.high = high;
                    }

                    /**
                     *
                     * @return
                     *     The low
                     */
                    public String getLow() {
                        return low + "°F";
                    }

                    /**
                     *
                     * @param low
                     *     The low
                     */
                    public void setLow(String low) {
                        this.low = low;
                    }

                    /**
                     *
                     * @return
                     *     The text
                     */
                    public String getText() {
                        return text;
                    }

                    /**
                     *
                     * @param text
                     *     The text
                     */
                    public void setText(String text) {
                        this.text = text;
                    }

                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }

                }
                public class Guid {

                    private String isPermaLink;
                    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                    /**
                     *
                     * @return
                     *     The isPermaLink
                     */
                    public String getIsPermaLink() {
                        return isPermaLink;
                    }

                    /**
                     *
                     * @param isPermaLink
                     *     The isPermaLink
                     */
                    public void setIsPermaLink(String isPermaLink) {
                        this.isPermaLink = isPermaLink;
                    }

                    public Map<String, Object> getAdditionalProperties() {
                        return this.additionalProperties;
                    }

                    public void setAdditionalProperty(String name, Object value) {
                        this.additionalProperties.put(name, value);
                    }

                }

                private String title;
                private String lat;
                private String _long;
                private String link;
                private String pubDate;
                private Condition condition;
                @SerializedName("forecast")
                private List<ForecastData> forecast = new ArrayList<>();
                private String description;
                private Guid guid;
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();

                /**
                 *
                 * @return
                 *     The title
                 */
                public String getTitle() {
                    return title;
                }

                /**
                 *
                 * @param title
                 *     The title
                 */
                public void setTitle(String title) {
                    this.title = title;
                }

                /**
                 *
                 * @return
                 *     The lat
                 */
                public String getLat() {
                    return lat;
                }

                /**
                 *
                 * @param lat
                 *     The lat
                 */
                public void setLat(String lat) {
                    this.lat = lat;
                }

                /**
                 *
                 * @return
                 *     The _long
                 */
                public String getLong() {
                    return _long;
                }

                /**
                 *
                 * @param _long
                 *     The long
                 */
                public void setLong(String _long) {
                    this._long = _long;
                }

                /**
                 *
                 * @return
                 *     The link
                 */
                public String getLink() {
                    return link;
                }

                /**
                 *
                 * @param link
                 *     The link
                 */
                public void setLink(String link) {
                    this.link = link;
                }

                /**
                 *
                 * @return
                 *     The pubDate
                 */
                public String getPubDate() {
                    return pubDate;
                }

                /**
                 *
                 * @param pubDate
                 *     The pubDate
                 */
                public void setPubDate(String pubDate) {
                    this.pubDate = pubDate;
                }

                /**
                 *
                 * @return
                 *     The condition
                 */
                public Condition getCondition() {
                    return condition;
                }

                /**
                 *
                 * @param condition
                 *     The condition
                 */
                public void setCondition(Condition condition) {
                    this.condition = condition;
                }

                /**
                 *
                 * @return
                 *     The forecast
                 */
                public List<ForecastData> getForecast() {
                    return forecast;
                }

                /**
                 *
                 * @param forecast
                 *     The forecast
                 */
                public void setForecast(List<ForecastData> forecast) {
                    this.forecast = forecast;
                }

                /**
                 *
                 * @return
                 *     The description
                 */
                public String getDescription() {
                    return description;
                }

                /**
                 *
                 * @param description
                 *     The description
                 */
                public void setDescription(String description) {
                    this.description = description;
                }

                /**
                 *
                 * @return
                 *     The guid
                 */
                public Guid getGuid() {
                    return guid;
                }

                /**
                 *
                 * @param guid
                 *     The guid
                 */
                public void setGuid(Guid guid) {
                    this.guid = guid;
                }

                public Map<String, Object> getAdditionalProperties() {
                    return this.additionalProperties;
                }

                public void setAdditionalProperty(String name, Object value) {
                    this.additionalProperties.put(name, value);
                }

            }


            private Units units;
            private String title;
            private String link;
            private String description;
            private String language;
            private String lastBuildDate;
            private String ttl;
            private Location location;
            private Wind wind;
            private Atmosphere atmosphere;
            private Astronomy astronomy;
            private Image image;
            private Item item;
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();

            /**
             *
             * @return
             *     The units
             */
            public Units getUnits() {
                return units;
            }

            /**
             *
             * @param units
             *     The units
             */
            public void setUnits(Units units) {
                this.units = units;
            }

            /**
             *
             * @return
             *     The title
             */
            public String getTitle() {
                return title;
            }

            /**
             *
             * @param title
             *     The title
             */
            public void setTitle(String title) {
                this.title = title;
            }

            /**
             *
             * @return
             *     The link
             */
            public String getLink() {
                return link;
            }

            /**
             *
             * @param link
             *     The link
             */
            public void setLink(String link) {
                this.link = link;
            }

            /**
             *
             * @return
             *     The description
             */
            public String getDescription() {
                return description;
            }

            /**
             *
             * @param description
             *     The description
             */
            public void setDescription(String description) {
                this.description = description;
            }

            /**
             *
             * @return
             *     The language
             */
            public String getLanguage() {
                return language;
            }

            /**
             *
             * @param language
             *     The language
             */
            public void setLanguage(String language) {
                this.language = language;
            }

            /**
             *
             * @return
             *     The lastBuildDate
             */
            public String getLastBuildDate() {
                return lastBuildDate;
            }

            /**
             *
             * @param lastBuildDate
             *     The lastBuildDate
             */
            public void setLastBuildDate(String lastBuildDate) {
                this.lastBuildDate = lastBuildDate;
            }

            /**
             *
             * @return
             *     The ttl
             */
            public String getTtl() {
                return ttl;
            }

            /**
             *
             * @param ttl
             *     The ttl
             */
            public void setTtl(String ttl) {
                this.ttl = ttl;
            }

            /**
             *
             * @return
             *     The location
             */
            public Location getLocation() {
                return location;
            }

            /**
             *
             * @param location
             *     The location
             */
            public void setLocation(Location location) {
                this.location = location;
            }

            /**
             *
             * @return
             *     The wind
             */
            public Wind getWind() {
                return wind;
            }

            /**
             *
             * @param wind
             *     The wind
             */
            public void setWind(Wind wind) {
                this.wind = wind;
            }

            /**
             *
             * @return
             *     The atmosphere
             */
            public Atmosphere getAtmosphere() {
                return atmosphere;
            }

            /**
             *
             * @param atmosphere
             *     The atmosphere
             */
            public void setAtmosphere(Atmosphere atmosphere) {
                this.atmosphere = atmosphere;
            }

            /**
             *
             * @return
             *     The astronomy
             */
            public Astronomy getAstronomy() {
                return astronomy;
            }

            /**
             *
             * @param astronomy
             *     The astronomy
             */
            public void setAstronomy(Astronomy astronomy) {
                this.astronomy = astronomy;
            }

            /**
             *
             * @return
             *     The image
             */
            public Image getImage() {
                return image;
            }

            /**
             *
             * @param image
             *     The image
             */
            public void setImage(Image image) {
                this.image = image;
            }

            /**
             *
             * @return
             *     The item
             */
            public Item getItem() {
                return item;
            }

            /**
             *
             * @param item
             *     The item
             */
            public void setItem(Item item) {
                this.item = item;
            }

            public Map<String, Object> getAdditionalProperties() {
                return this.additionalProperties;
            }

            public void setAdditionalProperty(String name, Object value) {
                this.additionalProperties.put(name, value);
            }

        }


        private Channel channel;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         *
         * @return
         *     The channel
         */
        public Channel getChannel() {
            return channel;
        }

        /**
         *
         * @param channel
         *     The channel
         */
        public void setChannel(Channel channel) {
            this.channel = channel;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    private Integer count;
    private String created;
    private String lang;
    private Results results;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * 
     * @param lang
     *     The lang
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * 
     * @return
     *     The results
     */
    public Results getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(Results results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
