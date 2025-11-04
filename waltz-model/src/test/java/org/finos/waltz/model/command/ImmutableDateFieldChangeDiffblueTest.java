package org.finos.waltz.model.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class ImmutableDateFieldChangeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableDateFieldChange.Builder#build()}
   *   <li>{@link ImmutableDateFieldChange.Builder#description(String)}
   *   <li>{@link ImmutableDateFieldChange.Builder#newVal(Date)}
   *   <li>{@link ImmutableDateFieldChange.Builder#oldVal(Date)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange
    ImmutableDateFieldChange.Builder descriptionResult = ImmutableDateFieldChange.builder()
        .description("The characteristics of someone or something");
    Date newVal = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableDateFieldChange.Builder newValResult = descriptionResult.newVal(newVal);
    Date oldVal = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Act
    ImmutableDateFieldChange actualBuildResult = newValResult.oldVal(oldVal).build();

    // Assert
    assertEquals("The characteristics of someone or something", actualBuildResult.description());
    assertSame(newVal, actualBuildResult.newVal());
    assertSame(oldVal, actualBuildResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange.Builder#from(DateFieldChange)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableDateFieldChange.Builder builderResult = ImmutableDateFieldChange.builder();
    DateFieldChange instance = mock(DateFieldChange.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.newVal()).thenReturn(fromResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.oldVal()).thenReturn(fromResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableDateFieldChange buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(fromResult, buildResult.newVal());
    assertSame(fromResult2, buildResult.oldVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange.Builder#from(DateFieldChange)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableDateFieldChange.Builder builderResult = ImmutableDateFieldChange.builder();
    DateFieldChange instance = mock(DateFieldChange.class);
    when(instance.newVal()).thenReturn(null);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.oldVal()).thenReturn(fromResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableDateFieldChange buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.newVal());
    assertSame(fromResult, buildResult.oldVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange.Builder#from(DateFieldChange)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableDateFieldChange.Builder builderResult = ImmutableDateFieldChange.builder();
    DateFieldChange instance = mock(DateFieldChange.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.newVal()).thenReturn(fromResult);
    when(instance.oldVal()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableDateFieldChange buildResult = builderResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.oldVal());
    assertSame(fromResult, buildResult.newVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange.Builder#from(DateFieldChange)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableDateFieldChange.Builder builderResult = ImmutableDateFieldChange.builder();
    DateFieldChange instance = mock(DateFieldChange.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.newVal()).thenReturn(fromResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.oldVal()).thenReturn(fromResult2);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableDateFieldChange.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    ImmutableDateFieldChange buildResult = builderResult.build();
    assertNull(buildResult.description());
    assertSame(fromResult, buildResult.newVal());
    assertSame(fromResult2, buildResult.oldVal());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange#copyOf(DateFieldChange)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    DateFieldChange instance = mock(DateFieldChange.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.newVal()).thenReturn(fromResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.oldVal()).thenReturn(fromResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange actualCopyOfResult = ImmutableDateFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertSame(fromResult, actualCopyOfResult.newVal());
    assertSame(fromResult2, actualCopyOfResult.oldVal());
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange#copyOf(DateFieldChange)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    DateFieldChange instance = mock(DateFieldChange.class);
    when(instance.newVal()).thenReturn(null);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.oldVal()).thenReturn(fromResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange actualCopyOfResult = ImmutableDateFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.newVal());
    assertSame(fromResult, actualCopyOfResult.oldVal());
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange#copyOf(DateFieldChange)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    DateFieldChange instance = mock(DateFieldChange.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.newVal()).thenReturn(fromResult);
    when(instance.oldVal()).thenReturn(null);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableDateFieldChange actualCopyOfResult = ImmutableDateFieldChange.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).newVal();
    verify(instance).oldVal();
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.oldVal());
    assertSame(fromResult, actualCopyOfResult.newVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange#fromJson(ImmutableDateFieldChange.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange
        .fromJson(new ImmutableDateFieldChange.Json());

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange#fromJson(ImmutableDateFieldChange.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableDateFieldChange.Json json = new ImmutableDateFieldChange.Json();
    json.setNewVal(null);
    json.setOldVal(null);
    json.setDescription("Json");

    // Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertNull(actualFromJsonResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange#fromJson(ImmutableDateFieldChange.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableDateFieldChange.Json json = new ImmutableDateFieldChange.Json();
    json.setNewVal(null);
    Date oldVal = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    json.setOldVal(oldVal);
    json.setDescription(null);

    // Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.newVal());
    assertSame(oldVal, actualFromJsonResult.oldVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange#fromJson(ImmutableDateFieldChange.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableDateFieldChange.Json json = new ImmutableDateFieldChange.Json();
    Date newVal = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    json.setNewVal(newVal);
    json.setOldVal(null);
    json.setDescription(null);

    // Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.description());
    assertNull(actualFromJsonResult.oldVal());
    assertSame(newVal, actualFromJsonResult.newVal());
  }

  /**
   * Method under test:
   * {@link ImmutableDateFieldChange#fromJson(ImmutableDateFieldChange.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    ImmutableDateFieldChange.Json json = new ImmutableDateFieldChange.Json();
    json.setNewVal(mock(java.sql.Date.class));
    json.setOldVal(null);
    json.setDescription("Json");

    // Act
    ImmutableDateFieldChange actualFromJsonResult = ImmutableDateFieldChange.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertNull(actualFromJsonResult.oldVal());
    java.util.Date expectedNewValResult = json.newVal;
    assertSame(expectedNewValResult, actualFromJsonResult.newVal());
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateFieldChange.Json()).description());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableDateFieldChange.Json}
   *   <li>{@link ImmutableDateFieldChange.Json#setDescription(String)}
   *   <li>{@link ImmutableDateFieldChange.Json#setNewVal(Date)}
   *   <li>{@link ImmutableDateFieldChange.Json#setOldVal(Date)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableDateFieldChange.Json actualJson = new ImmutableDateFieldChange.Json();
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setNewVal(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualJson.setOldVal(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals("The characteristics of someone or something", actualJson.description);
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange.Json#newVal()}
   */
  @Test
  void testJsonNewVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateFieldChange.Json()).newVal());
  }

  /**
   * Method under test: {@link ImmutableDateFieldChange.Json#oldVal()}
   */
  @Test
  void testJsonOldVal() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableDateFieldChange.Json()).oldVal());
  }
}
