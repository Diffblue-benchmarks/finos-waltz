package org.finos.waltz.service.entity_alias;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.waltz.data.entity_alias.EntityAliasDao;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityAliasServiceDiffblueTest {
  @Mock private EntityAliasDao entityAliasDao;

  @InjectMocks private EntityAliasService entityAliasService;

  /**
   * Test {@link EntityAliasService#findAliasesForEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link EntityAliasService#findAliasesForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findAliasesForEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityAliasService.findAliasesForEntityReference(EntityReference)"})
  void testFindAliasesForEntityReference() {
    // Arrange
    when(entityAliasDao.findAliasesForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAliasesForEntityReferenceResult =
        entityAliasService.findAliasesForEntityReference(null);

    // Assert
    verify(entityAliasDao).findAliasesForEntityReference(isNull());
    assertTrue(actualFindAliasesForEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link EntityAliasService#updateAliases(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  @DisplayName(
      "Test updateAliases(EntityReference, Collection); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityAliasService.updateAliases(EntityReference, Collection)"})
  void testUpdateAliases_given42_whenArrayListAdd42() {
    // Arrange
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("42");
    aliases.add("foo");

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, aliases);

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateAliasesResult);
  }

  /**
   * Test {@link EntityAliasService#updateAliases(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  @DisplayName(
      "Test updateAliases(EntityReference, Collection); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityAliasService.updateAliases(EntityReference, Collection)"})
  void testUpdateAliases_givenFoo_whenArrayListAddFoo() {
    // Arrange
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    ArrayList<String> aliases = new ArrayList<>();
    aliases.add("foo");

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, aliases);

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateAliasesResult);
  }

  /**
   * Test {@link EntityAliasService#updateAliases(EntityReference, Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityAliasService#updateAliases(EntityReference, Collection)}
   */
  @Test
  @DisplayName("Test updateAliases(EntityReference, Collection); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] EntityAliasService.updateAliases(EntityReference, Collection)"})
  void testUpdateAliases_whenArrayList() {
    // Arrange
    when(entityAliasDao.updateAliases(
            Mockito.<EntityReference>any(), Mockito.<Collection<String>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    // Act
    int[] actualUpdateAliasesResult = entityAliasService.updateAliases(null, new ArrayList<>());

    // Assert
    verify(entityAliasDao).updateAliases(isNull(), isA(Collection.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualUpdateAliasesResult);
  }
}
