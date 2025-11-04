package org.finos.waltz.model.allocation_scheme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableAllocationSchemeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAllocationScheme#builder()}
   *   <li>{@link ImmutableAllocationScheme#description(String)}
   *   <li>{@link ImmutableAllocationScheme#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAllocationScheme.Builder actualExternalIdResult = ImmutableAllocationScheme.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableAllocationScheme.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(AllocationScheme)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    ImmutableAllocationScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.measurableCategoryId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(AllocationScheme)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(AllocationScheme)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    ImmutableAllocationScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.measurableCategoryId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(AllocationScheme)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    ImmutableAllocationScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.measurableCategoryId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#from(AllocationScheme)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    ImmutableAllocationScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.measurableCategoryId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Builder#measurableCategoryId(long)}
   */
  @Test
  void testBuilderMeasurableCategoryId() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategoryId(1L));
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAllocationScheme.Builder builderResult = ImmutableAllocationScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme#copyOf(AllocationScheme)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme actualCopyOfResult = ImmutableAllocationScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableCategoryId());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme#copyOf(AllocationScheme)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme actualCopyOfResult = ImmutableAllocationScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableCategoryId());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme#copyOf(AllocationScheme)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AllocationScheme instance = mock(AllocationScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.measurableCategoryId()).thenReturn(1L);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAllocationScheme actualCopyOfResult = ImmutableAllocationScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).measurableCategoryId();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.measurableCategoryId());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationScheme.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationScheme.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationScheme.Json()).id());
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Json#measurableCategoryId()}
   */
  @Test
  void testJsonMeasurableCategoryId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAllocationScheme.Json()).measurableCategoryId());
  }

  /**
   * Method under test: {@link ImmutableAllocationScheme.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAllocationScheme.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAllocationScheme.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAllocationScheme.Json actualJson = new ImmutableAllocationScheme.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertEquals(0L, actualJson.measurableCategoryId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.measurableCategoryIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAllocationScheme.Json#setMeasurableCategoryId(long)}
   */
  @Test
  void testJsonSetMeasurableCategoryId() {
    // Arrange
    ImmutableAllocationScheme.Json json = new ImmutableAllocationScheme.Json();

    // Act
    json.setMeasurableCategoryId(1L);

    // Assert
    assertEquals(1L, json.measurableCategoryId);
    assertTrue(json.measurableCategoryIdIsSet);
  }
}
