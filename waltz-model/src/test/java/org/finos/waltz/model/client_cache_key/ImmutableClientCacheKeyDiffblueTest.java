package org.finos.waltz.model.client_cache_key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey.Builder;
import org.finos.waltz.model.client_cache_key.ImmutableClientCacheKey.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableClientCacheKeyDiffblueTest {
  /**
   * Test {@link ImmutableClientCacheKey#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableClientCacheKey#builder()}
   *   <li>{@link ImmutableClientCacheKey#lastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableClientCacheKey Builder.build()", "Builder Builder.lastUpdatedAt(LocalDateTime)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableClientCacheKey.builder();

    // Assert
    assertSame(actualBuilderResult, actualBuilderResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay()));
  }

  /**
   * Test Builder {@link Builder#from(ClientCacheKey)}.
   * <ul>
   *   <li>Then builder build guid is {@code 1234}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ClientCacheKey)}
   */
  @Test
  @DisplayName("Test Builder from(ClientCacheKey); then builder build guid is '1234'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ClientCacheKey)"})
  void testBuilderFrom_thenBuilderBuildGuidIs1234() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();
    ClientCacheKey instance = mock(ClientCacheKey.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.guid()).thenReturn("1234");
    when(instance.key()).thenReturn("Key");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).guid();
    verify(instance).key();
    verify(instance).lastUpdatedAt();
    ImmutableClientCacheKey buildResult = builderResult.build();
    assertEquals("1234", buildResult.guid());
    assertEquals("Key", buildResult.key());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ClientCacheKey)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ClientCacheKey)}
   */
  @Test
  @DisplayName("Test Builder from(ClientCacheKey); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ClientCacheKey)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();
    ClientCacheKey instance = mock(ClientCacheKey.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.guid()).thenReturn("1234");
    when(instance.key()).thenReturn("Key");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).guid();
    verify(instance).key();
    verify(instance).lastUpdatedAt();
  }

  /**
   * Test Builder {@link Builder#guid(String)}.
   * <p>
   * Method under test: {@link Builder#guid(String)}
   */
  @Test
  @DisplayName("Test Builder guid(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.guid(String)"})
  void testBuilderGuid() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.guid("1234"));
  }

  /**
   * Test Builder {@link Builder#key(String)}.
   * <p>
   * Method under test: {@link Builder#key(String)}
   */
  @Test
  @DisplayName("Test Builder key(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.key(String)"})
  void testBuilderKey() {
    // Arrange
    Builder builderResult = ImmutableClientCacheKey.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.key("Key"));
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setGuid(String)}
   *   <li>{@link Json#setKey(String)}
   *   <li>{@link Json#setLastUpdatedAt(LocalDateTime)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setGuid(String)", "void Json.setKey(String)",
      "void Json.setLastUpdatedAt(LocalDateTime)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setGuid("1234");
    actualJson.setKey("Key");
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdatedAt(ofResult.atStartOfDay());

    // Assert
    LocalDateTime localDateTime = actualJson.lastUpdatedAt;
    assertEquals("00:00", localDateTime.toLocalTime().toString());
    LocalDate toLocalDateResult = localDateTime.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#guid()}.
   * <p>
   * Method under test: {@link Json#guid()}
   */
  @Test
  @DisplayName("Test Json guid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.guid()"})
  void testJsonGuid() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).guid());
  }

  /**
   * Test Json {@link Json#key()}.
   * <p>
   * Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).key());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }
}
