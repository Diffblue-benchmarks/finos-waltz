package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceRecipientsAndOwnersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addAllOwnerPersonIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllOwnerPersonIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addAllOwnerPersonIds(Iterable)}
   */
  @Test
  void testBuilderAddAllOwnerPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddAllOwnerPersonIdsResult = builderResult
        .addAllOwnerPersonIds(elements);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllOwnerPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addAllRecipientPersonIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRecipientPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRecipientPersonIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addAllRecipientPersonIds(Iterable)}
   */
  @Test
  void testBuilderAddAllRecipientPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddAllRecipientPersonIdsResult = builderResult
        .addAllRecipientPersonIds(elements);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddAllRecipientPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addOwnerPersonIds(long)}
   */
  @Test
  void testBuilderAddOwnerPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddOwnerPersonIdsResult = builderResult
        .addOwnerPersonIds(1L);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddOwnerPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addOwnerPersonIds(long[])}
   */
  @Test
  void testBuilderAddOwnerPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddOwnerPersonIdsResult = builderResult
        .addOwnerPersonIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(2, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(-1L));
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddOwnerPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addRecipientPersonIds(long)}
   */
  @Test
  void testBuilderAddRecipientPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddRecipientPersonIdsResult = builderResult
        .addRecipientPersonIds(1L);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddRecipientPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#addRecipientPersonIds(long[])}
   */
  @Test
  void testBuilderAddRecipientPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualAddRecipientPersonIdsResult = builderResult
        .addRecipientPersonIds(1L, -1L, 1L, -1L);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(2, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(-1L));
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualAddRecipientPersonIdsResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#build()}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#ownerId(String)}
   *   <li>
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#owningRole(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners actualBuildResult = ImmutableSurveyInstanceRecipientsAndOwners.builder()
        .ownerId("42")
        .owningRole("Owning Role")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.ownerId());
    assertEquals("Owning Role", actualBuildResult.owningRole());
    assertTrue(actualBuildResult.ownerPersonIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    ImmutableSurveyInstanceRecipientsAndOwners buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerId());
    assertEquals("Owning Role", buildResult.owningRole());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn(null);
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    ImmutableSurveyInstanceRecipientsAndOwners buildResult = builderResult.build();
    assertEquals("Owning Role", buildResult.owningRole());
    assertNull(buildResult.ownerId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn(null);
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    ImmutableSurveyInstanceRecipientsAndOwners buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerId());
    assertNull(buildResult.owningRole());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(resultLongSet);
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    ImmutableSurveyInstanceRecipientsAndOwners buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerId());
    assertEquals("Owning Role", buildResult.owningRole());
    Set<Long> ownerPersonIdsResult = buildResult.ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#from(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(resultLongSet);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    ImmutableSurveyInstanceRecipientsAndOwners buildResult = builderResult.build();
    assertEquals("42", buildResult.ownerId());
    assertEquals("Owning Role", buildResult.owningRole());
    Set<Long> recipientPersonIdsResult = buildResult.recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#ownerPersonIds(Iterable)}
   */
  @Test
  void testBuilderOwnerPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerPersonIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#ownerPersonIds(Iterable)}
   */
  @Test
  void testBuilderOwnerPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualOwnerPersonIdsResult = builderResult
        .ownerPersonIds(elements);

    // Assert
    Set<Long> ownerPersonIdsResult = builderResult.build().ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertSame(builderResult, actualOwnerPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#recipientPersonIds(Iterable)}
   */
  @Test
  void testBuilderRecipientPersonIds() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.recipientPersonIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Builder#recipientPersonIds(Iterable)}
   */
  @Test
  void testBuilderRecipientPersonIds2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Builder builderResult = ImmutableSurveyInstanceRecipientsAndOwners
        .builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners.Builder actualRecipientPersonIdsResult = builderResult
        .recipientPersonIds(elements);

    // Assert
    Set<Long> recipientPersonIdsResult = builderResult.build().recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertSame(builderResult, actualRecipientPersonIdsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualCopyOfResult = ImmutableSurveyInstanceRecipientsAndOwners
        .copyOf(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    assertEquals("42", actualCopyOfResult.ownerId());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualCopyOfResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualCopyOfResult.recipientPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(resultLongSet);
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualCopyOfResult = ImmutableSurveyInstanceRecipientsAndOwners
        .copyOf(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    assertEquals("42", actualCopyOfResult.ownerId());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualCopyOfResult.ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertTrue(actualCopyOfResult.recipientPersonIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(resultLongSet);
    when(instance.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualCopyOfResult = ImmutableSurveyInstanceRecipientsAndOwners
        .copyOf(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    assertEquals("42", actualCopyOfResult.ownerId());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    assertTrue(actualCopyOfResult.recipientPersonIds().isEmpty());
    assertEquals(resultLongSet, actualCopyOfResult.ownerPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#copyOf(SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyInstanceRecipientsAndOwners instance = mock(SurveyInstanceRecipientsAndOwners.class);
    when(instance.ownerId()).thenReturn("42");
    when(instance.owningRole()).thenReturn("Owning Role");
    when(instance.ownerPersonIds()).thenReturn(new HashSet<>());
    when(instance.recipientPersonIds()).thenReturn(resultLongSet);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualCopyOfResult = ImmutableSurveyInstanceRecipientsAndOwners
        .copyOf(instance);

    // Assert
    verify(instance).ownerId();
    verify(instance).ownerPersonIds();
    verify(instance).owningRole();
    verify(instance).recipientPersonIds();
    assertEquals("42", actualCopyOfResult.ownerId());
    assertEquals("Owning Role", actualCopyOfResult.owningRole());
    Set<Long> recipientPersonIdsResult = actualCopyOfResult.recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertTrue(actualCopyOfResult.ownerPersonIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    Set<Long> resultLongSet = json.recipientPersonIds;
    assertSame(resultLongSet, ownerPersonIdsResult);
    assertSame(resultLongSet, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(null);
    json.setOwningRole(null);
    json.setOwnerId(null);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(null);
    json.setOwningRole(null);
    json.setOwnerId("Json");

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(null);
    json.setOwningRole("Json");
    json.setOwnerId(null);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.owningRole());
    assertNull(actualFromJsonResult.ownerId());
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertTrue(ownerPersonIdsResult.isEmpty());
    assertSame(ownerPersonIdsResult, actualFromJsonResult.recipientPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<Long> ownerPersonIds = new LinkedHashSet<>();
    ownerPersonIds.add(1L);

    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(ownerPersonIds);
    json.setOwningRole(null);
    json.setOwnerId(null);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> ownerPersonIdsResult = actualFromJsonResult.ownerPersonIds();
    assertEquals(1, ownerPersonIdsResult.size());
    assertTrue(ownerPersonIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.recipientPersonIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson6() {
    // Arrange
    LinkedHashSet<Long> recipientPersonIds = new LinkedHashSet<>();
    recipientPersonIds.add(1L);

    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(recipientPersonIds);
    json.setOwnerPersonIds(null);
    json.setOwningRole(null);
    json.setOwnerId(null);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    Set<Long> recipientPersonIdsResult = actualFromJsonResult.recipientPersonIds();
    assertEquals(1, recipientPersonIdsResult.size());
    assertTrue(recipientPersonIdsResult.contains(1L));
    assertTrue(actualFromJsonResult.ownerPersonIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners#fromJson(ImmutableSurveyInstanceRecipientsAndOwners.Json)}
   */
  @Test
  void testFromJson7() {
    // Arrange
    LinkedHashSet<Long> ownerPersonIds = new LinkedHashSet<>();
    ownerPersonIds.add(-1L);
    ownerPersonIds.add(1L);

    ImmutableSurveyInstanceRecipientsAndOwners.Json json = new ImmutableSurveyInstanceRecipientsAndOwners.Json();
    json.setRecipientPersonIds(null);
    json.setOwnerPersonIds(ownerPersonIds);
    json.setOwningRole(null);
    json.setOwnerId(null);

    // Act
    ImmutableSurveyInstanceRecipientsAndOwners actualFromJsonResult = ImmutableSurveyInstanceRecipientsAndOwners
        .fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.ownerId());
    assertNull(actualFromJsonResult.owningRole());
    assertTrue(actualFromJsonResult.recipientPersonIds().isEmpty());
    assertEquals(ownerPersonIds, actualFromJsonResult.ownerPersonIds());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceRecipientsAndOwners.Json actualJson = new ImmutableSurveyInstanceRecipientsAndOwners.Json();

    // Assert
    assertNull(actualJson.ownerId);
    assertNull(actualJson.owningRole);
    assertTrue(actualJson.ownerPersonIds.isEmpty());
    assertTrue(actualJson.recipientPersonIds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Json#ownerId()}
   */
  @Test
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientsAndOwners.Json()).ownerId());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Json#ownerPersonIds()}
   */
  @Test
  void testJsonOwnerPersonIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientsAndOwners.Json()).ownerPersonIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Json#owningRole()}
   */
  @Test
  void testJsonOwningRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientsAndOwners.Json()).owningRole());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceRecipientsAndOwners.Json#recipientPersonIds()}
   */
  @Test
  void testJsonRecipientPersonIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceRecipientsAndOwners.Json()).recipientPersonIds());
  }
}
